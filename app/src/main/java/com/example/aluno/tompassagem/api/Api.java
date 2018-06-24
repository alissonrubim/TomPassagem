package com.example.aluno.tompassagem.api;

import android.os.AsyncTask;

import com.example.aluno.tompassagem.models.Usuario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Api {
    public static Usuario UsuarioLogado;

    public class Servico extends AsyncTask<String,Void,String> {
        private String action;
        private String JSONParameters;
        private String token;
        private String method;


        public Servico(String action, String JSONParameters, String token, String method){
            this.action = action;
            this.JSONParameters = JSONParameters;
            this.token = token;
            this.method = method;
        }

        @Override
        protected String doInBackground(String... param) {
            String result = null;
            try {
                URL url = new URL("https://service.davesmartins.com.br/api/" + action);

                HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();

                if(method == "GET")
                    urlConnection.setRequestMethod("GET");
                else
                    urlConnection.setRequestMethod("POST");

                urlConnection.setReadTimeout(95 * 1000);
                urlConnection.setConnectTimeout(95 * 1000);
                urlConnection.setDoInput(true);
                urlConnection.setRequestProperty("Accept", "application/json");
                urlConnection.setRequestProperty("Content-Type", "application/json");
                if(token != null && !token.isEmpty())
                    urlConnection.setRequestProperty("code", token);
                urlConnection.setRequestProperty("X-Environment", "android");

                if(JSONParameters != null && !JSONParameters.isEmpty())
                    urlConnection.getOutputStream().write(JSONParameters.getBytes());

                urlConnection.connect();

                int urlRequestCode = urlConnection.getResponseCode();
                if (urlRequestCode == 200) {
                    InputStream responseBody = urlConnection.getInputStream();
                    InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");
                    BufferedReader reader = new BufferedReader(responseBodyReader);
                    StringBuffer buffer = new StringBuffer();
                    String line ="";

                    while ((line=reader.readLine())!=null){
                        buffer.append(line);
                    }

                    result = buffer.toString();
                } else {
                    result = "";
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }
    }


    protected String Execute(String action, String JSONParameters, String token, String method) throws MalformedURLException, IOException, Exception{
        Servico servico = new Servico(action, JSONParameters, token, method);
        String result = servico.execute().get();
        return result;
    }
}
