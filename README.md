# quadroDeAvisos


Quadro de Avisos Construído para a disciplina de Sistemas Digitais da PUC GO


Foram feitas diversas modificações, para que existam duas telas de execução, uma
eviando avisos via Java RMI (Método Remóto) e outra recebendo os Aviso e mostrando
a quem estiver executando (Recebe usando RMI e adiciona automaticamente via Observer)

Foram colocadas algumas informações extras, para mostrar quem enviou o Alerta e o 
momento em que o Alerta foi enviado.


Para executar, basta seguir a ordem;
1º Executar o registro -> RmiRegistro.java
  - Ele irá incializar tanto o registro quanto o servidor de RMI.
2º Executar Emissor de Alertas -> EmissorDeAlertas.java
  - Esse programa já possui interface gráfica, e serve para emitir os alertas.
3º Executar Quadro de Alertas -> QuadroDeAlertas.java
  - Esse programa também possui interface gráfica, e é responsavel por mostrar 
  os alertas recebidos.
  
O RMI é usado para que os programas possam utilizar métodos remotos como se
estivessem usando um método local do computador, quando na verdade, em tese
seu codigo não existe na maquina que está executando.

O padrão  Observer, fica encarregado de enxergar mudanças no objeto. No caso
do quadro de avisos, cada vez que um aviso é emitido, uma mudança é feita no 
objeto armazenado no Registro. Logo após detectada a mudança, a mesma é 
repassada aos "clientes" conectados.


Obs: Maior parte do código(RMI e Observer) foi fornecida pelo professor.
