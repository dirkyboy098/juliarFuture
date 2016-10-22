grammar juliargrammar;

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
    : ID (INT)?
    ;

acos
    : ID
    ;

acosh
    : ID
    ;

add
    : ID INT INT
    ;


/*
 * Lexer Rules
 */

INT: [0-9]+ ;
FLOAT : ('0'..'9')+ '.' ('0'..'9')*;
STRING : '"' ('0'..'9'|'a'..'z'|'A'..'Z'|'_'|' ')* '"';
ID : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
WS : [ \t\r\n]+ -> skip ;

