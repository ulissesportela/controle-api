package com.cobras.controle.domain.model;

import java.util.HashMap;
import java.util.Map;

public enum TipoUnidade {
	MATRIZ(1), 
	PARCEIRA(2), 
	PROPRIA(3);
	
    private Integer valor;
    
    private static Map map = new HashMap<>();

    private TipoUnidade(Integer valor) {
        this.valor = valor;
    }

    static {
        for (TipoUnidade tipo : TipoUnidade.values()) {
            map.put(tipo.valor, tipo);
        }
    }

    public static TipoUnidade valueOf(Integer tipo) {
        return (TipoUnidade) map.get(tipo);
    }

    public Integer getValor() {
        return valor;
    }
}
