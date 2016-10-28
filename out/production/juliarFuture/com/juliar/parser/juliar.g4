grammar juliar;

/*
 * Parser Rules
 */

compileUnit
	:	statement
	;

statement
    : (startLine command endLine)*
	;

startLine
    : asterisk
    ;

endLine
    : asterisk
    ;

asterisk
    : '*'
    ;


command
    : absolute
    | acos
    | acosh
    | add
	| subtract
	| minus
 /*
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

minus
	: '-'
	;

subtract
	: ID (FLOAT)*
	| ID (INT)*
	| ID INT INT
	;

types
    : INT
    | FLOAT
    | DOUBLE
    | LONG
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

