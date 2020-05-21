
function Corrente() {
  this.getSaldoEspecial = () => {
    return this.saldoEspecial;
  };

  this.setSaldoEspecial = (saldoEspecial) => {
    this.saldoEspecial = saldoEspecial;
  };
}

Corrente.prototype = new Conta();