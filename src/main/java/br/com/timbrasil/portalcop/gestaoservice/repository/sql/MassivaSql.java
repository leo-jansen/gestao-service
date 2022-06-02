package br.com.timbrasil.portalcop.gestaoservice.repository.sql;

public class MassivaSql {
  public static final String GET_MASSIVAS_METALICO = """
  SELECT
    A.ID, A.ID_MASSIVA AS idMassiva, A.ID_TP_ACAO AS idAcao, B.DESC_TP_ACAO AS descAcao,
    (
      CASE
        WHEN A.ID_TP_ACAO = 1 THEN TO_CHAR (DT_ABERTURA, 'dd/mm/yyyy hh24:mi:ss')
        ELSE TO_CHAR (
          DT_MANUTENCAO_PROGRAMADA,
          'dd/mm/yyyy hh24:mi:ss'
        )
      END
    ) DT_ABERTURA AS dataAbertura,
    A.TIPO AS tipo, A.STATUS AS status, A.MSAN AS msan, A.PAR_INI AS parInicio,
    A.PAR_FIM AS parFim, A.UF AS uf, A.CIDADE AS cidade, A.ID_TP_FALHA AS idFalha,
    (
      CASE
        WHEN A.ID_TP_FALHA = 0 THEN C.DESC_TP_MANUTENCAO
        ELSE D.DESC_TP_FALHA
      END
    ) DESC_TP_FALHA AS descFalha,
    A.ID_AREA AS idArea, E.DESC_AREA AS descArea, A.PRAZO AS prazo,
    (
      CASE
        WHEN TIPO = 'S' THEN (
          CASE
            WHEN SYSDATE >= (A.DT_ABERTURA (1 / 12)) THEN 'S'
            WHEN SYSDATE >= (A.DT_ABERTURA (1 / 24 * 1.5)) THEN 'A1'
            WHEN SYSDATE >= (A.DT_ABERTURA (1 / 24)) THEN 'A2'
            ELSE 'N'
          END
        )
        ELSE (
          CASE
            WHEN SYSDATE > (A.PRAZO) THEN 'S'
            WHEN SYSDATE > (A.PRAZO - (1 / 24)) THEN 'A1'
            WHEN SYSDATE > (A.PRAZO - (2 / 24)) THEN 'A2'
            ELSE 'N'
          END
        )
      END
    ) EXPIRADO AS expirado,
    EMPREITEIRA AS empreiteira,
    NVL2(QTD_CLIENTES, TO_CHAR(QTD_CLIENTES), '?') AS QTD_CLIENTES AS qtdClientes,
    TO_CHAR (
      DT_INI_INDISPONIBILIDADE,
      'dd/mm/yyyy hh24:mi:ss'
    ) AS DT_INI_INDISPONIBILIDADE AS dataInicioIndisponibilidade,
    TO_CHAR (
      DT_FIM_INDISPONIBILIDADE,
      'dd/mm/yyyy hh24:mi:ss'
    ) AS DT_FIM_INDISPONIBILIDADE AS dataFimIndisponibilidade,
    NVL(C.FLAG_INDISPONIBILIDADE, 1) INDISPONIBILIDADE AS indisponibilidade,
    A.OBSERVACAO AS observacao
  FROM
    CICOP.COP_APP_METAL_MASSIVA A,
    CICOP.COP_APP_METAL_TP_ACAO B,
    CICOP.COP_APP_METAL_TP_MANUTENCAO C,
    CICOP.COP_APP_METAL_TP_FALHA D,
    CICOP.COP_APP_METAL_AREA E
  WHERE
    A.STATUS = 0
    AND B.ID_TP_ACAO = A.ID_TP_ACAO
    AND C.ID_TP_MANUTENCAO () = A.ID_TP_MANUTENCAO
    AND D.ID_TP_FALHA () = A.ID_TP_FALHA
    AND E.ID_AREA = A.ID_AREA
  ORDER BY
    A.DT_ABERTURA
  """;

  public static final String GET_RELATORIO_MASSIVAS_METALICO = """
    SELECT
    TB1.ID_MASSIVA,
    TB2.SERVICEID as SERVICE_ID,
    TB2.NRM_MDF as MDF,
    TB2.SGF_CAIXA as CAIXA,
    TB2.SGF_PAR as PAR
  FROM
    CICOP.COP_APP_METAL_MASSIVA TB1,
    CICOP.COP_APP_METAL_MASS_SERVICEID TB2
  WHERE
    TB2.FK_METAL_MASSIVA = TB1.ID
    AND TB1.ID = :idMassiva
      """;
}
