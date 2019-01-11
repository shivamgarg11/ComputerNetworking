package com.shivam.computernetworking.Algos;
//
// Created by Shivam Garg on 11/01/19.
//


import java.security.SecureRandom;


public class selectivendrep

{

	int TOT_FRAMES = 1000;
	int FRAMES_SEND = 1000;
	String str = "";


	int fr_send_at_instance;

	int[] arr = new int[TOT_FRAMES];

	int[] send = new int[FRAMES_SEND];

	int[] rcvd = new int[FRAMES_SEND];

	char[] rcvd_ack = new char[FRAMES_SEND];

	int sw;

	int rw;       //tells expected frame


	public String input(int n) {    //no. of bits for the frame
		int m;    //no. of frames from n bits
		int i;
		m = (int) Math.pow(2, n)%1000;
		int t = 0;
		fr_send_at_instance = (m / 2);
		for (i = 0; i < TOT_FRAMES; i++) {
			arr[i] = t;
			t = (t + 1) % m;
		}
		for (i = 0; i < fr_send_at_instance; i++) {
			send[i] = arr[i];
			rcvd[i] = arr[i];
			rcvd_ack[i] = 'n';
		}
		rw = sw = fr_send_at_instance;
		sender(m);
		return str;

	}

	void sender(int m) {
		for (int i = 0; i < fr_send_at_instance; i++) {
			if (rcvd_ack[i] == 'n')
				str = str + "SENDER : Frame " + send[i] + " is sent\n";
		}
		receiver(m);
	}

	void receiver(int m) {

		int f;
		int j;
		int f1;
		int a1;
		char ch;
		SecureRandom s=new SecureRandom();
		//s.generateSeed((int) System.currentTimeMillis());
		for (int i = 0; i < fr_send_at_instance; i++) {
			if (rcvd_ack[i] == 'n') {
				f = (int) (Math.random() % 10);
//if f=5 frame is discarded for some reason
//else frame is correctly recieved
				if (f != 5) {
					for ( j = 0; j < fr_send_at_instance; j++)
						if (rcvd[j] == send[i]) {
							str += "reciever:Frame" + rcvd[j] + "recieved correctly\n";
							rcvd[j] = arr[rw];
							rw = (rw + 1) % m;
							break;
						}
					if (j == fr_send_at_instance)
						str += "reciever:Duplicate frame" + send[i] + "discarded\n";
					a1 = (int) (Math.random() % 5);
//if al==3 then ack is lost
//else recieved
					if (a1 == 3) {
						str += "(acknowledgement " + send[i] + " lost)\n";
						str += "(sender timeouts-->Resend the frame)\n";
						rcvd_ack[i] = 'n';
					} else {
						str += "(acknowledgement " + send[i] + " recieved)\n";
						rcvd_ack[i] = 'p';
					}
				} else {
					int ld = (int) (Math.random() % 2);
//if =0 then frame damaged
//else frame lost
					if (ld == 0) {
						str += "RECEIVER : Frame " + send[i] + " is damaged\n";
						str += "RECEIVER : Negative Acknowledgement " + send[i] + " sent\n";
					} else {
						str += "RECEIVER : Frame " + send[i] + " is lost\n";
						str += "(SENDER TIMEOUTS-->RESEND THE FRAME)\n";
					}
					rcvd_ack[i] = 'n';
				}
			}
		}
		for (j = 0; j < fr_send_at_instance; j++) {
			if (rcvd_ack[j] == 'n')
				break;
		}
		int i = 0;
		for (int k = j; k < fr_send_at_instance; k++) {
			send[i] = send[k];
			if (rcvd_ack[k] == 'n')
				rcvd_ack[i] = 'n';
			else
				rcvd_ack[i] = 'p';
			i++;
		}
		if (i != fr_send_at_instance) {
			for (int k = i; k < fr_send_at_instance; k++) {
				send[k] = arr[sw];
				sw = (sw + 1) % m;
				rcvd_ack[k] = 'n';
			}
		}


	}

}