package com.company;
interface Cipher {

    /** deszyfrowanie wiadomosci*/
    String decode(final String message);

    /** szyfrowanie wiadomosci */
    String encode(final String message);
}

class AtBashCipher implements Cipher {

    @Override
    public String decode(String message) {
       char[] array= message.toCharArray();

       for(int i=0;i<array.length-1;i++){
           if(array[i]>96 &&array[i]<123) {
               array[i] = (char) ((char) 219 - (int) array[i]);
           }
       }
       return String.valueOf(array);
       }


    @Override
    public String encode(String message) {
        return decode( message) ;
    }
}

class Main {

    public static void main(String[] args) {

        Cipher atBashCipher = new AtBashCipher();

        // Encode: Zoz nz plgz
        System.out.println("Encode: " + atBashCipher.encode("Ala ma kota"));

        // Decode: Ala ma kota
        System.out.println("Decode: " + atBashCipher.decode("Zoz nz plgz"));
    }
}