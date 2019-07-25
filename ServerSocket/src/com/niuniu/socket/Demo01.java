package com.niuniu.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//Socket����� ��̬��ν���
public class Demo01 {
	 	private static BufferedReader br=null;
	    private static PrintWriter pw=null;
	    private static ServerSocket ss;
	    private static Socket s;
	    static Scanner scanner=new Scanner(System.in);
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try {
            ss=new ServerSocket(1001);
            System.out.println("����������������������");
            s=ss.accept();//��������
            System.out.println("���ӳɹ�"+s.getRemoteSocketAddress());
            br=new BufferedReader(new InputStreamReader(s.getInputStream()));
            pw=new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
            while(true){
                String string=br.readLine();
                System.out.println("����˶�����"+string);
                System.out.println("����˶������룺");
                String str=scanner.next();
                pw.println(str);
                pw.flush();
                if(str.equals("exit")){
                    break;
                }
            }
        } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
		 try {
	            pw.close();
	            br.close();
	        } catch (IOException e) {
	                // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}

}
