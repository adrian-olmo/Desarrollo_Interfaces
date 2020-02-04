/*console.log("HOLA MUNDO");
console.log("Prueba de linea de codigo");
console.log("Esto es un nuevo cambio");
console.log ("Ejemplo de tsc -w / --watch");*/
let numero: number = 1
let nombre: string = 'Adrian'
let apellido: string = 'Olmo'
//console.log(nombre+" "+apellido);
console.log(`${nombre} ${apellido}`);
let nota:number = 5;
/*if (nota>=5) {
    console.log("Has aprobado")
} else if (nota < 5 && nota > 2) {
    console.log("Has suspendido");
} else {
    console.log("FATAL ERROR")
}*/
console.log("------SWITCH------")
switch (nota) {
    case 1:
        console.log("Caso 1")
        break;

    case 2:
        console.log("Caso 2")
        break;

    default:
        console.log("Resto de casos")
        break;
}
console.log("------FOR------")

for (let index = 0; index < 10; index++) {
    console.log(`Elemento  ${index}`);
    
}
let conjuntoPalabras:string[] = ["primero", "segundo", "tercero", "cuarto"];

console.log("------FOR IN------")
for (const key in conjuntoPalabras) {
    console.log(conjuntoPalabras[key])
}

console.log("------FOR EACH------")

conjuntoPalabras.forEach(elemento => {
    console.log(elemento)
});

console.log("------FOR OF------")

for (const iterator of conjuntoPalabras) {
    console.log(iterator)
}


console.log("------FUNCIONES------")
function funcionInicial(nombre:string) {
    console.log(nombre)
}

function funcionInicialParametros(nombre:string, apellido:string, edad:number) {
    console.log(`${nombre}, ${apellido}, ${edad}`)
}

function funcionRetorno(numUno:number, numDos:number): number {
    return numUno+numDos
    
}

function funcionCualquierParametro(params:any) {
    console.log(params)
}

function funcionParamertrosMultiples(nombre:string,...nombresMultiples:string[]) {
    console.log(nombre);
    if (nombresMultiples.length) {
        nombresMultiples.forEach(element => {
            console.log(element);
            
        });
    }else{
        console.log("No han pasado parametros multiples");
        
    }
    
}

function funcionParametrosOptativos(nombre:string, apellido:string, edad?:number){
    if (edad == null) {
        console.log(`${nombre} ${apellido}`);
        
    } else {
        console.log(`${nombre} ${apellido} ${edad}`);
    }
}

function funcionValoresDefecto(nombre:string, apellido:string="defecto") {
    console.log(`${nombre}, ${apellido}`);
    
}

funcionInicial(`MiNombre`) //Saca lo que le pongas entre ()
funcionInicialParametros(`Adrian`,`Olmo`, 20) //Acepta los parametros definidos
console.log(funcionRetorno(44,53)) //Devuelve el retorno definido en la funcion
funcionCualquierParametro(false) //Acepta cualquier tipo de parametro
funcionParamertrosMultiples('Adri', 'Negro') //Saca los parametros que le pases, en este caso si hay un parametro saca un mensaje
funcionParametrosOptativos('Adri', 'Negro', 20) //Parametros Optativos
funcionValoresDefecto(`Adri`) //Si no estableces el 2º valor saca el defecto