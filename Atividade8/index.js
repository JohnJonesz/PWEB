const janela = document.getElementById('janela')

function fecharJanela () {
  janela.src = 'assets/janelaFechada.jpg'
}

function abrirJanela() {
  janela.src = 'assets/janelaAberta.png'
}

function quebrarJanela() {
  janela.src = 'assets/janelaQuebrada.png'
}

janela.addEventListener('click', quebrarJanela)
janela.addEventListener('mouseenter', abrirJanela)
janela.addEventListener('mouseleave', fecharJanela)
