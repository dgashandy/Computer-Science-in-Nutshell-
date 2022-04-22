package PRG;

import javax.naming.NoPermissionException;

class Node {
	String nama;
    int NIP;
    int masaKerja;
    int gaji;
    Node next, prev;

}

class DoublyLinkedList {
	 Node head;
	 Node tail;
	 boolean isEmpty() {
		 return (head == null);
	    }
	    void addFirst(Node masukan) {
	        if (isEmpty()) {
	            head = masukan;
	            tail = masukan;

	        }
	        else {
	            masukan.next = head;
	            head.prev = masukan;
	            head = masukan;
	        }
	    }

	    void addLast(Node masukan) {
	        if (isEmpty()) {
	            head = masukan;
	            tail = masukan;
	        }
	        else {
	            tail.next = masukan;
	            masukan.prev = tail;
	            tail = masukan;
	        }
	    }
	    void insertSorted(Node masukan) {
	        if (isEmpty()) {
	            head = masukan;
	            tail = masukan;
	        }
	        else {
	            if (masukan.NIP < head.NIP) {
	                this.addFirst(masukan);
	            }
	            else if (masukan.NIP > tail.NIP) {
	                this.addLast(masukan);
	            }
	            else {
	                Node h = head;
	                while (h.NIP < masukan.NIP)
	                    h = h.next;

	                if(h.NIP == masukan.NIP) {
	                    h.NIP += masukan.NIP;
	                }
	                else {
	                    masukan.next = h;
	                    h.prev.next = masukan;
	                    masukan.prev = h.prev;
	                    h.prev = masukan;
	                }
	            }
	        }
	    }
	    void pindahToArray(Karyawan[] Daftar) {
	        Node temp;
	        temp = head;
	        int i = 0;

	        while (temp != null) {
	            Daftar[i] = new Karyawan();
	            Daftar[i].nama = temp.nama;
	            Daftar[i].NIP = temp.NIP;
	            Daftar[i].masaKerja = temp.masaKerja;
	            Daftar[i].gaji = temp.gaji;
	            temp = temp.next;
	            i++;
	        }
	    }
	}



