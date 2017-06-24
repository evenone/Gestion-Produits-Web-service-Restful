package org.sid;

import java.util.List;

import org.sid.dao.ProduitRepository;
import org.sid.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CataServiceApplication  implements CommandLineRunner{
	@Autowired
	private ProduitRepository produitRepository;
	public static void main(String[] args) {
		SpringApplication.run(CataServiceApplication.class, args);
		
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		//ProduitRepository produitRepository=ctx.getBean(ProduitRepository.class);
		produitRepository.save(new Produit("HP 500", 500, 20));
		produitRepository.save(new Produit("SA 65", 600, 30));
		produitRepository.save(new Produit("SU 44", 700, 40));
		List<Produit> prods=produitRepository.findAll();
		prods.forEach(p->System.out.println(p.getDesignation()));
	
	}
}
