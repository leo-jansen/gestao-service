package br.com.timbrasil.portalcop.gestaoservice.form;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MassivaMetalicaForm {
  private String id;
  @NotBlank @NotEmpty @NotNull
  private String idMassiva;
  @NotBlank @NotEmpty @NotNull
  private int idAcao;
  @NotBlank @NotEmpty @NotNull
  private String descAcao;
  @NotBlank @NotEmpty @NotNull
  private String dataAbertura;
  @NotBlank @NotEmpty @NotNull
  private String tipo;
  @NotBlank @NotEmpty @NotNull
  private int status;
  @NotBlank @NotEmpty @NotNull
  private String msan;
  @NotBlank @NotEmpty @NotNull
  private String parInicio;
  @NotBlank @NotEmpty @NotNull
  private String parFim;
  @NotBlank @NotEmpty @NotNull
  private String uf;
  @NotBlank @NotEmpty @NotNull
  private String cidade;
  @NotBlank @NotEmpty @NotNull
  private int idFalha;
  @NotBlank @NotEmpty @NotNull
  private String descFalha;
  @NotBlank @NotEmpty @NotNull
  private int idArea;
  @NotBlank @NotEmpty @NotNull
  private String descArea;
  @NotBlank @NotEmpty @NotNull
  private LocalDateTime prazo;
  @NotBlank @NotEmpty @NotNull
  private String expirado;
  @NotBlank @NotEmpty @NotNull
  private String empreiteira;
  @NotBlank @NotEmpty @NotNull
  private int qtdClientes;
  @NotBlank @NotEmpty @NotNull
  private String dataInicioIndisponibilidade;
  @NotBlank @NotEmpty @NotNull
  private String dataFimIndisponibilidade;
  @NotBlank @NotEmpty @NotNull
  private int indisponibilidade;
  @NotBlank @NotEmpty @NotNull
  private String observacao;
}
