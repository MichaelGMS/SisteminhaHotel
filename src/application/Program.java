package application;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import model.entities.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Número do Quarto: ");
		int numeroQuarto = sc.nextInt();
		System.out.print("Data do Check-In (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data do Check-Out (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: Check-Out com data anterior ao Check-In");

		} else {
			Reserva reserva = new Reserva(numeroQuarto, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);

			System.out.println();
			System.out.println("Coloque a data atualizada da reserva: ");
			System.out.print("Data do Check-In (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data do Check-Out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			Date agora = new Date();
			if (checkIn.before(agora) || checkOut.before(agora)) {
				System.out.println("Erro na reserva: As datas de reserva para atualização devem ser futuras");
			}
			else if (!checkOut.after(checkIn)){
				System.out.println("Erro na reserva: Check-Out com data anterior ao Check-In");
			}
			else {
				reserva.atualizarDias(checkIn, checkOut);
				System.out.println("Reserva: " + reserva);
			}
		}

		sc.close();
	}
}
