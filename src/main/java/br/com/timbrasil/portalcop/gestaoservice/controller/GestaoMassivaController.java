package br.com.timbrasil.portalcop.gestaoservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.timbrasil.portalcop.gestaoservice.dto.MassivaMetalicaDto;
import br.com.timbrasil.portalcop.gestaoservice.form.MassivaMetalicaForm;
import br.com.timbrasil.portalcop.gestaoservice.service.GestaoMassivaService;

@RestController
@RequestMapping("/gestaoMassiva")
public class GestaoMassivaController {
  @Autowired
  private GestaoMassivaService gestaoMassivaService;

  @GetMapping
  public ResponseEntity<List<MassivaMetalicaDto>> getMassiva() {
    List<MassivaMetalicaDto> massivas = gestaoMassivaService.getMassiva();
    if (massivas.isEmpty()) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(massivas);
  }

  @PostMapping("/novo")
  public ResponseEntity<MassivaMetalicaDto> cadastroMassivaMetalica(MassivaMetalicaForm massivaMetalica, String matricula) {
    MassivaMetalicaDto massiva = gestaoMassivaService.cadastroMassivaMetalica(massivaMetalica, matricula);
    return ResponseEntity.ok(massiva);
  }
}
