package com.gabrielpedrico.proposta.proposta.enums;

public enum StatusSolicitacao {
    SEM_RESTRICAO {
        @Override
        public StatusProposta conversorStatus() {
            return StatusProposta.ELEGIVEL;
        }
    }, COM_RESTRICAO {
        @Override
        public StatusProposta conversorStatus() {
            return StatusProposta.NAO_ELEGIVEL;
        }
    };

    public abstract StatusProposta conversorStatus();
}
