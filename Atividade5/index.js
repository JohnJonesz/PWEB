
var numero1 = prompt('Insira o primeiro número:');
var numero2 = prompt('Insira o segundo número:');
var numero3 = prompt('Insira o terceiro número:');


maiorNumero(numero1, numero2, numero3);

function maiorNumero(numero1, numero2, numero3) {
  var arrayNumeros = [numero1, numero2, numero3];

  arrayNumeros.sort((a, b) => a - b);

  alert("O maior número é o " + arrayNumeros[arrayNumeros.length - 1]);
}