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

plus
	: '+'
	;

minus
	: '-'
	;

command
    : absolute
    | acos
    | acosh
    | add
	| subtract
	| plus
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
    : ID (FLOAT)*
    | ID (INT)*
    | ID INT INT
    ;

subtract
	: ID (FLOAT)*
	;


/*
 * Lexer Rules
 */

INT: [0-9]+ ;
FLOAT : ('0'..'9')+ '.' ('0'..'9')*;
STRING : '"' ('0'..'9'|'a'..'z'|'A'..'Z'|'_'|' ')* '"';
ID : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
WS : [ \t\r\n]+ -> skip ;

