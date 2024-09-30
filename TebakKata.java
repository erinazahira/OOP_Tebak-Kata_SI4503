import java.util.Scanner;

public class TebakKata{
	public static void main( String[] args )
	{
		// List kata yang akan ditebak
		String[] list_kata = { "perbuatan", "telinga", "objek", "kuliah", "permainan", "makanan", "buku", "mobil" };
		// deklarasi variabel
		String random_word;
		char[] kata_tersembunyi;
		Scanner kunci = new Scanner(System.in);
		String tebakan_pemain;
		int kesempatan_salah = 0;
		char[] kesalahan = new char[11];
		boolean kata_ditemukan = false; 
		boolean selesai = false;
		
		// pembuatan kolom untuk kata yang akan ditebak
		random_word = list_kata[ (int)(Math.random() * list_kata.length) ];
		kata_tersembunyi = new char[random_word.length()];
		for ( int i = 0; i < random_word.length(); i++ )
		{
			kata_tersembunyi[i] = '_';
		}		
		
		// Game dijalankan
		while (kesempatan_salah < 10 && ! selesai)
		{
			System.out.println( "\n|||=======================================================|||\n" );
			System.out.println( "Kamu memiliki " + (10 - kesempatan_salah) + " kesempatan untuk menebak" );
			System.out.print( "Kata yang harus ditebak:\t" );
			for ( int i = 0; i < random_word.length(); i++ ) {
				System.out.print( kata_tersembunyi[i] + " " );
			}
			System.out.print("\nHuruf yang salah ditebak: ");
			for ( int i = 0; i < kesalahan.length; i++ ) {
				System.out.print( kesalahan[i] );
			}
			
			System.out.print( "\nTebak salah satu hurufnya: " );
		 	tebakan_pemain = kunci.next();
			kata_ditemukan = false;
			
			for ( int i = 0; i < random_word.length(); i++ ) {
				if (tebakan_pemain.charAt(0) == random_word.charAt(i) ) {
					kata_tersembunyi[i] = random_word.charAt(i);
					kata_ditemukan = true;
				}
			}
			if (!kata_ditemukan) {
				kesempatan_salah++;
				kesalahan[kesempatan_salah] = tebakan_pemain.charAt(0);	
			}
			
			int hidden_count = 0;
			for ( int i = 0; i < random_word.length(); i++ ) {
				if ( '_' == kata_tersembunyi[i] )
					hidden_count++;
			}
			if (hidden_count > 0) 
				selesai = false;
			else
				selesai = true;
		}

		System.out.println( "|||================================================|||\n" );
		System.out.println( "Kamu memiliki " + (10 - kesempatan_salah) + " kesempatan untuk menebak" );
		System.out.print( "Kata yang harus ditebak:\t" );
		for ( int i = 0; i < random_word.length(); i++ ) {
			System.out.print( kata_tersembunyi[i] + " " );
		}
		System.out.print("\nKesalahan menebak: ");
		for ( int i = 0; i < kesalahan.length; i++ ) {
			System.out.print( kesalahan[i] );
		}
	
	
		if (selesai)
			System.out.println( "\nYeay kamu berhasil menebak!\nkata yang ditebak adalah " + random_word);
		else
			System.out.println( "\n\nKesempatan kamu habis, kata yang harus ditebak adalah " + random_word );	
	}
}

