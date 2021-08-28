package jjh.api;

import jjh.api.item.controller.ItemController;
import jjh.api.item.domain.Item;
import jjh.api.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//개발순서: domain -> repository -> service -> controller
@SpringBootApplication
public class ItemApplication implements CommandLineRunner{
	@Autowired
	ItemService itemService;
	public static void main(String[] args) {
		SpringApplication.run(ItemApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		itemService.deleteAll();
		itemService.save(new Item("삼성", "갤럭시3", "흑색"));
		itemService.save(new Item("애플", "아이폰3", "흰색"));
		itemService.save(new Item("샤오미", "홍미3", "적색"));
		for (Item i : itemService.findAll()) {
			System.out.println(i.toString());
		}
	}


}
