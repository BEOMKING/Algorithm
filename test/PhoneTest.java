package test;

public class PhoneTest {
    public static void main(String[] args) {
        Phone [] phoneArray = new Phone[5];

        for( int i=0; i<phoneArray.length; i++ ) {
            phoneArray[i] = new Phone();
            phoneArray[i].setPrice(i*2000);
        }

        for( Phone phone : phoneArray ) {
            System.out.println( phone.getPrice() );
        }
        Phone phone = new Phone();

        phone.setName("Galaxy Note");
        phone.setColor('B');
        phone.setPrice(10000);

        System.out.println(phone);

    }
}
