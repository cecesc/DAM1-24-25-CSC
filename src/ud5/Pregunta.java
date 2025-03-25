package ud5;

public class Pregunta {
    String Enunciado;
    
}
/*Examen Test
1. Examen Test (5)
Implementa un modelo de clases en Java que permita la creación de exámenes tipo test. El
modelo debe incluir las siguientes clases:
1. La clase "Pregunta", que representará una pregunta de tipo test con varias opciones
de respuesta y una única opción correcta, y que tendrá los siguientes
a. atributos:
i. Enunciado de la pregunta
ii. Lista de respuestas
iii. Índice de la respuesta correcta
b. métodos:
i. un constructor que validará que la pregunta tenga al menos 2
respuestas diferentes y un índice de opción correcta válido, es decir,
dentro de los límites del número de respuestas..
ii. corregir() que recibe el índice de la opción elegida y devuelve true si
es la opción correcta y false si no lo es.
iii. el método redefinido toString(), que devolverá un String con el
enunciado de la pregunta y en las siguientes líneas las posibles
respuestas precedidas de las letras consecutivas del alfabeto, es
decir, a), b), c), d)...
iv. el método redefinido equals() considerará iguales dos preguntas que
tengan el mismo enunciado y la misma lista de respuestas.
2. La clase "Examen", que contendrá los siguientes
a. atributos:
i. un título del examen
ii. un conjunto de preguntas y los siguientes métodos:
b. métodos:
i. Un constructor que permita indicar el título.
ii. addPregunta() añade una pregunta al examen comprobando que no
se haya añadido ya una igual.
iii. numPreguntas() devuelve el número de preguntas del examen.
iv. el método redefinido toString(), que devolverá un String con el título
del examen y todas las preguntas del examen numeradas, con su
enunciado y sus respuestas pero sin indicar la opción correcta. */