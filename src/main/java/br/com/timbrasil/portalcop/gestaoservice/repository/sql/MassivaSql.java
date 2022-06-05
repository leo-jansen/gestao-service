package br.com.timbrasil.portalcop.gestaoservice.repository.sql;

public class MassivaSql {
  public static final String GET_MASSIVAS_METALICO = """
    SELECT
    new br.com.timbrasil.portalcop.gestaoservice.dto.MassivaDto(
      a.id, a.idMassiva, a.idTpAcao, b.descAcao,
      (
        CASE
          WHEN a.idTpAcao = 1 THEN TO_CHAR (a.dataAbertura, 'dd/mm/yyyy hh24:mi:ss')
          ELSE TO_CHAR (
            a.dataManutencaoProg,
            'dd/mm/yyyy hh24:mi:ss'
          )
        END
      ) dataAbertura,
      a.tipo, a.status, a.msan, a.parInicio, a.parFim, a.uf, a.cidade, a.idTpFalha,
      (
        CASE
          WHEN a.idTpFalha = 0 THEN c.descManutencao
          ELSE d.descFalha
        END
      ) descFalha,
      a.idArea, e.descArea, a.prazo,
      (
        CASE
          WHEN a.tipo = 'S' THEN (
            CASE
              WHEN SYSDATE >= (a.dataAbertura + (1 / 12)) THEN 'S'
              WHEN SYSDATE >= (a.dataAbertura + (1 / 24 * 1.5)) THEN 'A1'
              WHEN SYSDATE >= (a.dataAbertura + (1 / 24)) THEN 'A2'
              ELSE 'N'
            END
          )
          ELSE (
            CASE
              WHEN SYSDATE > (a.prazo) THEN 'S'
              WHEN SYSDATE > (a.prazo - (1 / 24)) THEN 'A1'
              WHEN SYSDATE > (a.prazo - (2 / 24)) THEN 'A2'
              ELSE 'N'
            END
          )
        END
      ) expirado,
      a.empreiteira,
      NVL2(a.quantClientes, TO_CHAR(a.quantClientes)) AS qtdClientes,
      TO_CHAR (
        a.dataIniIndisp,
        'dd/mm/yyyy hh24:mi:ss'
      ) AS dataInicioIndisponibilidade,
      TO_CHAR (
        a.dataFimIndisp,
        'dd/mm/yyyy hh24:mi:ss'
      ) AS dataFimIndisponibilidade,
      NVL(c.flagIndisponibilidade, 1) indisponibilidade,
      a.observacao
    )
  FROM
    Massiva a,
    Acao b, 
    Manutencao c,
    Falha d,
    Area e
  WHERE
    a.status = :status
    AND b.id = a.idTpAcao
    AND e.id = a.idArea
    AND c.id (+) = a.idTpManutencao
    AND d.id (+) = a.idTpFalha
  ORDER BY
    a.dataAbertura
  """;

  public static final String GET_RELATORIO_MASSIVAS_METALICO = """
  SELECT
    TB1.idMassiva,
    TB2.SERVICEID as SERVICE_ID,
    TB2.NRM_MDF as MDF,
    TB2.SGF_CAIXA as CAIXA,
    TB2.SGF_PAR as PAR
  FROM
    Massiva TB1,
    SERVICEID TB2
  WHERE
    TB2.FK_METAL_MASSIVA = TB1.ID
    AND TB1.ID = :idMassiva
  """;
}
