grammar juliar;

/*
 * Parser Rules
 */

compileUnit
	:	(functionDeclaration)*
	;

statement
    : (expression) endLine
	;

endLine
    : semiColon
    ;

semiColon
    : ';'
    ;

expressions
    : (expression)*
    //| (expression)?(expression)*
    //| assignmentExpression
    //| booleanExpression
    //| ifExpr
	//| nifExpr
    ;

expression
    : assignmentExpression
    | primitives
    | variabledeclartion
    | functionCall
    ;

assignmentExpression
    : variabledeclartion equalsign command
	| variabledeclartion equalsign variable
    ;


functionCall
    : funcName leftParen rightParen
    ;

functionDeclaration
    : 'function' funcName '()' equalsign '{' (statement)* '}'
    ;


funcName
    : ID
    ;


leftParen
    : '('
    ;

rightParen
    : ')'
    ;


/*
booleanExpression
    : variable (equalequal) variable
    | variable (equalequal) command
    | command (equalequal) command
    ;
*/

primitives
    : 'fileOpen' '(' STRING ')'
    | 'printLine' '(' STRING ')'
    | 'printInt' '(' ')'
    | 'printInt' '(' variable ')'
    | 'printFloat' '('')'
    | 'printDouble' '('')'
    ;

printPrimitives
    : 'printInt' '(' INT ')'
    | 'printInt' '(' variable ')'
    ;


command
    : add
    | primitives
	| subtract
	| multiply
	| divide
	| modulo
    /*
    | ifExpr
	| nifExpr
    | absolute
	| acos
	| acosh
	| absolute
    | acos
    | acosh
    | subtract
    */
    ;

variable
    : ID
    ;

variabledeclartion
    : keywords variable
    ;

add
    : summation types (types)*
    | summation types types
    ;
	
summation
    : '+'
    | 'add'
    ;

subtract
	: subtraction types (types)*
	| subtraction types types
	;
	
subtraction
	: '-'
	| 'subtract'
	;

multiply
    : multiplication types (types)*
    | multiplication types types
    ;

multiplication
    : '*'
    | 'multiply'
    ;

	
divide
    : division types (types)*
    | division types types
    ;
	
division
    : '/'
    | 'divide'
    ;

modulo
    : moduli types (types)*
    | moduli types types
    ;

moduli
    :'%'
    |'modulo'
    ;

types
    : primitiveTypes
    ;


primitiveTypes
    : numericTypes
    | BOOLEAN
    | NULL
    ;

numericTypes
    : INT
    | FLOAT
    | DOUBLE
    | LONG
    ;

equalsign
    : '='
    ;

equalequal
    : '=='
    ;

keywords
    : 'int'
    | 'float'
    | 'double'
    | 'long'
    | 'object'
    ;

/*
ifExpr
    : 'if' '(' booleanExpression ')' '{' (statement)* '}'
    ;

nifExpr
	: 'nif' '(' booleanExpression ')' '{' (statement)* '}'
	;

absolute
    : 'absolute' types (types)*
    | 'absolute' types types
    ;

acos
    : 'acos' types (types)*
    | 'acos' types types
    ;

acosh
    : 'acosh' types (types)*
    | 'acosh' types types
    ;
*/


arrowsign    /*Not Sure yet...it may conflict with comparison. Possibly <- would be better? */
    :'<='
    ;

/*
 * Lexer Rules
 */

NULL: 'null';
BOOLEAN: 'true'|'false';
INT: [0-9]+ ;
FLOAT : ('0'..'9')+ '.' ('0'..'9')*;
DOUBLE : ('0'..'9')+ '.' ('0'..'9')*;
LONG : ('0'..'9')+ '.' ('0'..'9')*;
STRING : '"' ('0'..'@' | 'a'..'z' | 'A'..'Z' | '_' | ' '..'.' | '\\' )* '"';
ID : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_'| '-' )*;
WS : [ \t\r\n]+ -> skip ;


COMMENT : '/*' (COMMENT|.)*? '*/' -> channel(HIDDEN) ;
LINE_COMMENT  : '//' .*? '\n' -> channel(HIDDEN) ;
