grammar Juliar;

/*
 * Parser Rules
 */

compileUnit
	: classifications*
    ;

classifications
    : functionDeclaration
    | userDefinedTypeDecl
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
    | userDefinedTypeFunctionReference endLine
    | userDefinedTypeVariableReference endLine
    | returnValue endLine
    | expressionSequence endLine
    ;

assignmentExpression
    : variableDeclaration equalsign ( command | variable | functionCall | primitiveTypes | booleanExpression | userDefinedTypeVariableReference | userDefinedTypeVariableReference)
    | userDefinedTypeVariableReference equalsign ( variable | primitiveTypes)
	;

reassignmentExpression
    : variable equalsign ( variable | functionCall | primitiveTypes | command |  userDefinedTypeVariableReference | userDefinedTypeFunctionReference )
    ;


functionCall
    : funcName '()'
    | funcName (leftParen)(WS)*(rightParen)
    | funcName (leftParen) variable (',' variable)? (rightParen)
    | funcName (leftParen)STRING(rightParen)
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
    : ( BOOLEAN | variable | command ) (comparisonOperator) ( variable | primitiveTypes | command | userDefinedTypeVariableReference | userDefinedTypeFunctionReference )
    ;

primitives
    : 'sysExec' '(' STRING ')'
    | 'sysExec' '(' variable ')'
    ;

command
    : add
    | primitives
	| subtract
	| multiply
	| divide
	| modulo
    ;

userDefinedTypeDecl
    : userDefinedTypeKeyWord userDefinedTypeName equalsign '{' (statement)* (functionDeclaration)* '}'
    ;

userDefinedTypeKeyWord
    : 'class'
    ;

userDefinedTypeName
    : ID
    ;

variable
    : ID
    ;

variableDeclaration
    : keywords variable
    | userDefinedTypeVariableDecl
    ;

userDefinedTypeVariableDecl
    : userDefinedTypeName variable
    | userDefinedTypeName ID equalsign (New userDefinedTypeName)
    ;


userDefinedTypeVariableReference
    : userDefinedTypeName(userDefinedTypeResolutionOperator)variable
    ;

userDefinedTypeFunctionReference
    : userDefinedTypeName(userDefinedTypeResolutionOperator)functionCall
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

breakKeyWord
    : Break
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

Break      : 'break';
Do         : 'do';
Instanceof : 'instanceof';
Typeof     : 'typeof';
Case       : 'case';
Else       : 'else';
New        : 'new';
Var        : 'var';
Catch      : 'catch';
Finally    : 'finally';
Return     : 'return';
Void       : 'void';
Continue   : 'continue';
For        : 'for';
Switch     : 'switch';
While      : 'while';
Debugger   : 'debugger';
Function   : 'function';
This       : 'this';
With       : 'with';
Default    : 'default';
If         : 'if';
Throw      : 'throw';
Delete     : 'delete';
In         : 'in';
Try        : 'try';

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

ifExpr
    : If '(' booleanExpression ')' '{' ( statement )* '}'
    ;


whileExpression
    : While '(' booleanExpression ')' '{' ( statement)* '}'
    ;


arrowsign    /*Not Sure yet...it may conflict with comparison. Possibly <- would be better? */
    :'<='
    ;

userDefinedTypeResolutionOperator
    : '::'
    ;

expressionSequence
 : singleExpression ( ',' singleExpression )*
 ;

 identifierName :
     ID
     ;


singleExpression
 /*
 : Function Identifier? '(' formalParameterList? ')' '{' functionBody '}' # FunctionExpression
 | singleExpression arguments                                             # ArgumentsExpression
 | New singleExpression arguments?                                        # NewExpression
 : singleExpression {!this.here(Visitor.LineTerminator)}? '++'   # PostIncrementExpression
 | singleExpression {!this.here(Visitor.LineTerminator)}? '--'   # PostDecreaseExpression
 */
 : Delete singleExpression                                                # DeleteExpression
 | Void singleExpression                                                  # VoidExpression
 | Typeof singleExpression                                                # TypeofExpression
 | singleExpression '[' expressionSequence ']'                            # MemberIndexExpression
 | singleExpression '.' identifierName                                    # MemberDotExpression
 | '++' singleExpression                                                  # PreIncrementExpression
 | '--' singleExpression                                                  # PreDecreaseExpression
 | '+' singleExpression                                                   # UnaryPlusExpression
 | '-' singleExpression                                                   # UnaryMinusExpression
 | '~' singleExpression                                                   # BitNotExpression
 | '!' singleExpression                                                   # NotExpression
 | singleExpression ( '*' | '/' | '%' ) singleExpression                  # MultiplicativeExpression
 | singleExpression ( '+' | '-' ) singleExpression                        # AdditiveExpression
 | singleExpression ( '<<' | '>>' | '>>>' ) singleExpression              # BitShiftExpression
 | singleExpression ( '<' | '>' | '<=' | '>=' ) singleExpression          # RelationalExpression
 | singleExpression Instanceof singleExpression                           # InstanceofExpression
 | singleExpression In singleExpression                                   # InExpression
 | singleExpression ( '==' | '!=' | '===' | '!==' ) singleExpression      # EqualityExpression
 | singleExpression '&' singleExpression                                  # BitAndExpression
 | singleExpression '^' singleExpression                                  # BitXOrExpression
 | singleExpression '|' singleExpression                                  # BitOrExpression
 | singleExpression '&&' singleExpression                                 # LogicalAndExpression
 | singleExpression '||' singleExpression                                 # LogicalOrExpression
 | singleExpression '?' singleExpression ':' singleExpression             # TernaryExpression
 | singleExpression '=' expressionSequence                                # AssignmentExpressionEx
 | singleExpression assignmentOperator expressionSequence                 # AssignmentOperatorExpression
 | This                                                                   # ThisExpression
 | Identifier                                                             # IdentifierExpression
 /*
 | literal                                                                # LiteralExpression
 | arrayLiteral                                                           # ArrayLiteralExpression
 | objectLiteral                                                          # ObjectLiteralExpression
 */
 | '(' expressionSequence ')'                                             # ParenthesizedExpression
 ;

assignmentOperator
 : '*='
 | '/='
 | '%='
 | '+='
 | '-='
 | '<<='
 | '>>='
 | '>>>='
 | '&='
 | '^='
 | '|='
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
    : '\\' ('\\"'|'\\'|'/'|'b'|'f'|'n'|'r'|'t')
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
