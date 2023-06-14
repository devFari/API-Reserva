package com.api.lab.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.lab.models.Reserva;
import com.api.lab.repository.ReservaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/reserva")
public class ReservaController {
	
	@Autowired
	private ReservaRepository reservaRepostory;
	
	@GetMapping
	public List<Reserva> Listar () {
			return reservaRepostory.findAll();
	}
	
@GetMapping ("/{reservaID}")
public ResponseEntity<Reserva> buscar (@PathVariable Long reservaID) {	
	Optional<Reserva> reserva= reservaRepostory.findById(reservaID);
	
	if (reserva.isPresent() ) {
		return ResponseEntity.ok(reserva.get());
	}
	
	return ResponseEntity.notFound().build();
}
@PostMapping
@ResponseStatus(HttpStatus.CREATED)
public Reserva adicionar(@RequestBody Reserva reserva) {
	return reservaRepostory.save(reserva);
}
@PutMapping("/{reservaID}")
public ResponseEntity<Reserva> atualizar(@PathVariable Long reservaID,
		@RequestBody Reserva reserva) {
	if (!reservaRepostory.existsById(reservaID)) {
		return ResponseEntity.notFound().build();
	}
	
		reserva.setCodReserva(reservaID);
		reserva=reservaRepostory.save(reserva);
		
		return ResponseEntity.ok(reserva);
			
}

}
