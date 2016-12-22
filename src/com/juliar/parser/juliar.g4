grammar juliar;

/*
 * Parser Rules
 */

compileUnit
	:	(statement)*
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

expression
    : (command)*
    | (command)?(command)*
    | assignmentExpression
    | booleanExpression
    | ifExpr
	| nifExpr
    ;

assignmentExpression
    : variable equalsign command
	| variable equalsign variable
    ;

booleanExpression
    : variable (equalequal) variable
    | variable (equalequal) command
    | variable (equalequal) variable
    ;

command
    : add
	| subtract
	| multiply
	| divide
    | ifExpr
	| nifExpr
	
    ;
/*
    : absolute
    | acos
    | acosh
    | add
	| subtract
	| minus
    | alternatecase
    | and
    | asin
    | asinh
    | ask
    | atan
    | atanh
    | baseconvert
    | block
*/

ifExpr
    : 'if' '(' booleanExpression ')' '{' (statement)* '}'
    ;
	
nifExpr
	: 'nif' '(' booleanExpression ')' '{' (statement)* '}'
	;

variable
    : ID
    ;

absolute
    : ID (FLOAT)*
    ;

acos
    : ID (FLOAT)*
    ;

acosh
    : ID (FLOAT)*
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
/*
Using 'x' for multiplcation means that a user won't be able to use x as a variable.
It is now a reserved symbol
*/
multiplication
    : 'x'
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
types
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

/*
 * Lexer Rules
 */

INT: [0-9]+ ;
FLOAT : ('0'..'9')+ '.' ('0'..'9')*;
DOUBLE : ('0'..'9')+ '.' ('0'..'9')*;
LONG : ('0'..'9')+ '.' ('0'..'9')*;
STRING : '"' ('0'..'9'|'a'..'z'|'A'..'Z'|'_'|' ')* '"';
ID : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_'| '-' )*;
WS : [ \t\r\n]+ -> skip ;

