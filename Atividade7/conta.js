
function Conta() {
  this.getNomeCorrentista = () => {
    return this.nomeCorrentista;
  };

  this.setNomeCorrentista = (nomeCorrentista) => {
    this.nomeCorrentista = nomeCorrentista;
  };

  this.getBanco = () => {
    return this.banco;
  };

  this.setBanco = (banco) => {
    this.banco = banco;
  };

  this.getNumeroConta = () => {
    return this.numeroConta;
  };

  this.setNumeroConta = (numeroConta) => {
    this.numeroConta = numeroConta;
  };

  this.getSaldo = () => {
    return this.saldo;
  };

  this.setSaldo = (saldo) => {
    this.saldo = saldo;
  };
}

