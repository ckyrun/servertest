package org.exite.servertest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.log4j.Logger;
import org.exite.servertest.db.DbHandler;

import java.io.*;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class ClientHandler implements Runnable {

    private static final Logger log = Logger.getLogger(ClientHandler.class);
    private static Socket clientDialog;

    public ClientHandler(Socket client) {
        ClientHandler.clientDialog = client;
    }

    @Override
    public void run() {

        try {
            DataOutputStream out = new DataOutputStream(clientDialog.getOutputStream());
            DataInputStream in = new DataInputStream(clientDialog.getInputStream());

            while (!clientDialog.isClosed()) {

                String code = "200";
                String message = "OK";
                Map<String, String> request;
                Gson gson = new Gson();

                try {
                    String jRequest = in.readUTF();
                    Type type = new TypeToken<Map<String, String>>(){}.getType();
                    request = gson.fromJson(jRequest, type);
                } catch (EOFException e){
                    break;
                }

                String typeDoc = request.get("typeDoc");
                String bodyDoc = request.get("bodyDoc");
                String fileName = request.get("fileName");
                byte[] buffer = Base64.getDecoder().decode(bodyDoc);

                EdiDocument ediDoc = MessageReader.getMessage(new ByteArrayInputStream(buffer), typeDoc);
                String sender = ediDoc.getSender();
                String recipient = ediDoc.getRecipient();
                request.put("sender", sender);
                request.put("recipient", recipient);

                log.info("Получено сообщение " + fileName + " отправитель " + sender + " получатель " + recipient);

                DbHandler dbh = new DbHandler(Config.DB_URL, Config.DB_USER, Config.DB_PASS);
                try {
                    dbh.insertMessage(request, buffer);
                    log.info("Сообщение " + fileName + " записано в базу.");
                } catch (Exception e) {
                    code = "500";
                    message = e.getMessage();
                    log.info(message + " сообщения " + fileName);
                }
                Map<String, String> response = new HashMap<>();
                response.put("code", code);
                response.put("message", message);
                response.put("fileName", fileName);

                String jResponse = gson.toJson(response);

                out.writeUTF(jResponse);
                log.info("Отправлен ответ на сообщение " + fileName);

                out.flush();
                Thread.sleep(3000);
            }

            in.close();
            out.close();
            clientDialog.close();

        } catch (IOException | ClassNotFoundException | InterruptedException e) {
            log.error(e);
        }
    }

}
