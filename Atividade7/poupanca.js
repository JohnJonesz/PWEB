
function Poupanca() {
  this.getJuros = () => {
    return this.juros;
  };

  this.setJuros = (juros) => {
    this.juros = juros;
  };

  this.getDataVencimento = () => {
    return this.dataVencimento;
  };

  this.setDataVencimento = (dataVencimento) => {
    this.dataVencimento = dataVencimento;
  };
}

Poupanca.prototype = new Conta();