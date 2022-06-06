package br.com.timbrasil.portalcop.gestaoservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.timbrasil.portalcop.gestaoservice.dto.MassivaDto;
import br.com.timbrasil.portalcop.gestaoservice.service.GestaoMassivaService;

@RestController
@RequestMapping("/gestaoMassiva")
public class GestaoMassivaController {
  @Autowired
  private GestaoMassivaService gestaoMassivaService;

  @GetMapping
  public ResponseEntity<List<MassivaDto>> getMassiva() {
    List<MassivaDto> massivas = gestaoMassivaService.getMassiva();
    if (massivas.isEmpty()) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(massivas);
  }
}
