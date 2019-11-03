package com.example.demo;

import com.example.demo.pojos.Tour;
import com.example.demo.pojos.TourPackage;
import com.example.demo.pojos.User;
import com.example.demo.repositories.TourPackageRepository;
import com.example.demo.repositories.TourRepository;
import com.example.demo.repositories.UserRepository;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {//gia na xrhimopoieis to run pou trexei parllhla me to api

	@Autowired
	private TourPackageRepository tourPackageRepository;

	@Autowired
	private TourRepository tourRepo;

	@Autowired
	private UserRepository userRepo;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//prepei na valoume dedomena sthn vash se ka8e tre3imo giati diagrafete h vash otan kleisei to api
		TourPackage tour1 = new TourPackage("best one",10000,"Mykonos");
		TourPackage tour2 = new TourPackage("wort one",500,"Salamina");
		TourPackage tour3 = new TourPackage("Relax in Ionia",3000,"Ionio");
		TourPackage tour4 = new TourPackage("Peloponese mountain",2000,"Peloponese");

		tourPackageRepository.save(tour1);
		tourPackageRepository.save(tour2);
		tourPackageRepository.save(tour3);
		tourPackageRepository.save(tour4);

		Tour tour5 = new Tour(50,10,"sightseeing","athens sites","a tour to see all ancient Athens");
		Tour tour6 = new Tour(10,5, "sightseeing", "kallithea sites", "manhattan of athens");

		/*TourPackage fake = new TourPackage("this is fake",10,"pathsia");
		tour6.setTourPackage(fake);*/
		tour5.setTourPackage(tour1);
		tour6.setTourPackage(tour1);

		tourRepo.save(tour5);
		tourRepo.save(tour6);

		Tour karitena = new Tour(400,50,"full day in karitena","eat and drink in karetina","eat and drink in karetina");
		Tour dimitsana = new Tour(400,50,"full day in dimitsana","eat and drink in dimitsana","eat and drink in dimitsana");
		Tour rafting = new Tour(400,50,"rafting in Lusious river","very nice","really good day");

		karitena.setTourPackage(tour4);
		dimitsana.setTourPackage(tour4);
		rafting.setTourPackage(tour4);

		tourRepo.save(karitena);
		tourRepo.save(dimitsana);
		tourRepo.save(rafting);

		User kostas = new User("Kostas","Mitsotakis",3, User.Status.NEW);
		User mitsos = new User("Dimitris","Koufontinas",50, User.Status.PLATINUM);
		User maria = new User("Maria","Damanaki",5, User.Status.LOYAL);
		User katerina = new User("Katerina","Notopoulou",20, User.Status.GOLD);
		userRepo.save(kostas);
		userRepo.save(mitsos);
		userRepo.save(maria);
		userRepo.save(katerina);

	}
}

