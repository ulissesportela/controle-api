package com.cobras.controle.domain.model;

import java.util.HashMap;
import java.util.Map;

public enum TipoUnidadeEnum {
	MATRIZ(1), 
	PARCEIRA(2), 
	PROPRIA(3);
	
    private Integer valor;
    
    private static Map<Object, Object> map = new HashMap<>();

    private TipoUnidadeEnum(Integer valor) {
        this.valor = valor;
    }

    static {
        for (TipoUnidadeEnum tipo : TipoUnidadeEnum.values()) {
            map.put(tipo.valor, tipo);
        }
    }

    public static TipoUnidadeEnum valueOf(Integer tipo) {
        return (TipoUnidadeEnum) map.get(tipo);
    }

    public Integer getValor() {
        return valor;
    }
    
}
