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
    | command (equalequal) command
    ;

primitives
    : 'fileOpen' '(' STRING ')'
    | 'printLine' '(' STRING ')'
    | 'printInt' '(' INT ')'
    | 'printFloat' '(' FLOAT ')'
    | 'printDouble' '(' DOUBLE ')'
    ;

command
    : primitives
    | add
	| subtract
	| multiply
	| divide
    | ifExpr
	| nifExpr
    | absolute
	| acos
	| acosh
	| absolute
    | acos
    | acosh
    | add
	| subtract
    ;


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

arrowsign    /*Not Sure yet...it may conflict with comparison. Possibly <- would be better? */
    :'<='
    ;

/*
 * Lexer Rules
 */

INT: [0-9]+ ;
FLOAT : ('0'..'9')+ '.' ('0'..'9')*;
DOUBLE : ('0'..'9')+ '.' ('0'..'9')*;
LONG : ('0'..'9')+ '.' ('0'..'9')*;
STRING : '"' ('0'..'9' | 'a'..'z' | 'A'..'Z' | '_' | ' ' | '\\' | ':' | '.' )* '"';
ID : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_'| '-' )*;
WS : [ \t\r\n]+ -> skip ;


COMMENT : '/*' (COMMENT|.)*? '*/' -> channel(HIDDEN) ;
LINE_COMMENT  : '//' .*? '\n' -> channel(HIDDEN) ;
