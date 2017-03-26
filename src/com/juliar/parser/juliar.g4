grammar juliar;

/*
 * Parser Rules
 */

compileUnit
	: (functionDeclaration)*
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
    : variabledeclartion
    | assignmentExpression
    | reassignmentExpression
    | booleanExpression
    | primitives
    | functionCall
    | returnValue
    ;

assignmentExpression
    : variabledeclartion equalsign command
	| variabledeclartion equalsign variable
	| variabledeclartion equalsign functionCall
	| variabledeclartion equalsign primitiveTypes
    ;

reassignmentExpression
    : variable equalsign variable
	| variable equalsign functionCall
	| variable equalsign primitiveTypes
    ;


functionCall
    : funcName '()'
    | funcName (leftParen) variable (',' variable)? (rightParen)
    ;

functionDeclaration
    : 'function' funcName '()' equalsign '{' (statement)* '}'
    | 'function' funcName leftParen variabledeclartion (',' variabledeclartion)? rightParen equalsign '{' (statement)* '}'
    ;


funcName
    : ID
    ;

returnValue
    : 'return'
    | 'return' (variable)
    | 'return' (functionCall)
    ;

leftParen
    : '('
    ;

rightParen
    : ')'
    ;



booleanExpression
    : variable (comparisonOperator) variable
    | variable (comparisonOperator) command
    | command (comparisonOperator) command
    ;


primitives
    : 'fileOpen' '(' STRING ')'
    | 'printLine' '(' types | variable')'
    | 'print' '(' types | variable')'
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
    | STRING
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

comparisonOperator
    : equalequal
    | lessthan
    | greaterthan
    | lessthanorequalto
    | greaterthanorequalto
    | threeway
    ;

equalequal: '==';
lessthan: '<';
greaterthan: '>';
lessthanorequalto: '<=' ;
greaterthanorequalto: '>=' ;
threeway: '<=>';


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
STRING : '"' ('0'..'@' | 'a'..'z' | 'A'..'Z' | '_' | ' '..'.' | '\\' | '/' | '}' | '{')* '"' | '`' ('0'..'@' | 'a'..'z' | 'A'..'Z' | '_' | ' '..'.' | '\\' | '/' | '}' | '{')* '`';
ID : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_'| '-' )*;
WS : [ \t\r\n]+ -> skip ;


COMMENT : '/*' (COMMENT|.)*? '*/' -> channel(HIDDEN) ;
LINE_COMMENT  : '//' .*? '\n' -> channel(HIDDEN) ;
