package br.com.inf3fm.charityconnect.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.inf3fm.charityconnect.entity.ONG;
import br.com.inf3fm.charityconnect.service.ONGService;

@RestController
@RequestMapping("/ong/")
public class ONGController {
	
	private ONGService ongService;

	public ONGController(ONGService ongService) {
		super();
		this.ongService = ongService;
	}
	
	@GetMapping("findAll")
	public ResponseEntity<List<ONG>> findAll() {
		List<ONG> ongs = ongService.findAll();
			return new ResponseEntity<List<ONG>>(ongs, HttpStatus.OK);
		}
	
	@GetMapping("findById/{id}")
	public ResponseEntity<ONG> findById(@PathVariable long id) {
		
		ONG ong = ongService.findById(id);
		
		return new ResponseEntity<ONG>(ong, HttpStatus.OK);
	}
	
	@PostMapping("create")
	public ResponseEntity<ONG> create(@RequestBody ONG ong) {
		ONG _ong = ongService.create(ong);
		
		return new ResponseEntity<ONG>(_ong,HttpStatus.OK);
	}
}

