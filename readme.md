Implementamos desde cero usando TDD un parseador que enunciamos así: 

Dado un string introducido por el usuario para buscar profesionales (en lenguaje natural y en ingles inicialmente) el parseador tiene que devolver una lista con todos los tokens contenidos en la frase. 
PERO HAY QUE EVITAR DIFERENTES SALIDA DE TOKENS para una MISMA ENTRADA. 

Ejemplos: 
Para "TEACHER" obtenemos ["teacher"] 
Para " teacher " obtenemos ["teacher"] 
Para "teachers" obtenemos ["teacher"] 
Para "teacher 777" obtenemos ["teacher"] 
Para "ruby on rails" obtenemos ["ruby", "rail"] 
Para "ruby on rails" obtenemos ["ruby", "rail"]
