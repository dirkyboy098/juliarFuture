grammar Juliar;

/*
 * Parser Rules
 */

compileUnit
	: classifications*
    ;

classifications
    : functionDeclaration
    | userDefinedType
    ;

statement
    : (expression)
	;

endLine
    : semiColon
    ;

semiColon
    : ';'
    ;

expression
    : variableDeclaration endLine
    | assignmentExpression endLine
    | reassignmentExpression endLine
    | booleanExpression endLine
    | breakKeyWord endLine
    | ifExpr
    | whileExpression
    | primitives endLine
    | functionCall endLine
    | returnValue endLine
    | userDefinedMemberResolution endLine
    ;

assignmentExpression
    : variableDeclaration equalsign command
    | variableDeclaration equalsign variable
	| variableDeclaration equalsign functionCall
	| variableDeclaration equalsign primitiveTypes
	| variableDeclaration equalsign booleanExpression
	| variableDeclaration equalsign userDefinedMemberResolution
	;

reassignmentExpression
    : variable equalsign variable
	| variable equalsign functionCall
	| variable equalsign primitiveTypes
	| variable equalsign command
    ;


functionCall
    : funcName '()'
    | funcName (leftParen)(WS)*(rightParen)
    | funcName (leftParen) variable (',' variable)? (rightParen)
    ;

functionDeclaration
    : 'function' funcName '()' equalsign '{' (statement)* '}'
    | 'function' funcName leftParen variableDeclaration (',' variableDeclaration)? rightParen equalsign '{' (statement)* '}'
    ;


funcName
    : ID
    ;

returnValue
    : 'return'
    | 'return' types
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
    : BOOLEAN
    | variable (comparisonOperator) variable
    | variable (comparisonOperator) primitiveTypes
    | variable (comparisonOperator) command
    | command (comparisonOperator) command
    ;


primitives
    : 'printLine' '(' types ')'
    | 'printLine' '(' variable ')'
    | 'fileOpen' '(' STRING ')'
    | 'fileOpen' '(' variable ')'
    | 'print' '(' variable ')'
    | 'print' '(' (variable | types ) ')'
    | 'availableMemory' '()'
    ;




command
    : add
    | primitives
	| subtract
	| multiply
	| divide
	| modulo
    ;

userDefinedType
    : userDefinedTypeKeyWord userDefinedTypeName equalsign '{' (statement)* (functionDeclaration)* '}'
    ;

userDefinedTypeKeyWord
    : 'class'
    ;

userDefinedTypeName
    : ID
    ;

userDefinedMemberResolution
    : userDefinedTypeName(userDefinedTypeResolutionOperator)variable
    | userDefinedTypeName(userDefinedTypeResolutionOperator)functionCall
    ;

variable
    : ID
    ;

variableDeclaration
    : keywords variable
    | userDefinedTypeName variable
    ;

add
    : summation types (types)*
    | summation types types
    | summation variable (types)+
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
    | 'boolean'
    | 'string'
    | 'class'
    ;

breakKeyWord
    : 'break'
    ;

ifKeyWord
    : 'if'
    ;

ifExpr
    : ifKeyWord '(' booleanExpression ')' '{' ( statement )* '}'
    ;


whileKeyWord
    : 'while'
    ;

whileExpression
    : whileKeyWord '(' booleanExpression ')' '{' ( statement)* '}'
    ;


arrowsign    /*Not Sure yet...it may conflict with comparison. Possibly <- would be better? */
    :'<='
    ;

userDefinedTypeResolutionOperator
    : '::'
    ;

/*
 * Lexer Rules
 */

NULL
    :'null'
    ;

BOOLEAN
    : 'true'
    |'false'
    ;

INT
    : [0-9]+
    ;

FLOAT
    : ('0'..'9')+ '.' ('0'..'9')*
    ;

DOUBLE
    : ('0'..'9')+ '.' ('0'..'9')*
    ;

LONG
    : ('0'..'9')+ '.' ('0'..'9')*
    ;

ESC_CHARS
    : '\\' ('\"'|'\\'|'/'|'b'|'f'|'n'|'r'|'t')
    | '\\' 'u' [0-9a-fA-F] [0-9a-fA-F] [0-9a-fA-F] [0-9a-fA-F]
    ;

STRING
    :  '"' ( ESC_CHARS | ~('\\'|'"') )* '"' |'\'' ( ESC_CHARS  | ~('\\'|'\'') )* '\''  |'`' (ESC_CHARS | ~('\\'| '`') )* '`'
    ;

ID
    : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_'| '-' )*
    ;

WS
    : [ \t\r\n]+ -> skip
    ;

COMMENT
    : '/*' (COMMENT|.)*? '*/' -> channel(HIDDEN)
    ;

LINE_COMMENT
    : '//' .*? '\n' -> channel(HIDDEN)
    ;
