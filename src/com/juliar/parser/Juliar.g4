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
    | doWhileExpr
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
    | booleanAndOperator
    | booleanOrOperator
    | notOperator
    | bitWiseOperators
    ;

bitWiseOperators
    : bitAnd
    | bitOr
    | bitXor
    | bitNot
    | bitLeftShift
    | bitRigthShift
    ;

equalequal          : '==' ;
lessthan            : '<'  ;
greaterthan         : '>'  ;
lessthanorequalto   : '<=' ;
greaterthanorequalto: '>=' ;
threeway            : '<=>';
booleanAndOperator  : '&&' ;
booleanOrOperator   : '||' ;
notOperator         : '!'  ;
bitAnd              : '&'  ;
bitOr               : '|'  ;
bitXor              : '^'  ;
bitNot              : '~'  ;
bitLeftShift        : '<<' ;
bitRigthShift       : '>>' ;

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
    : If '(' singleExpression ')' '{' ( statement )* '}'
    ;


whileExpression
    : While '(' singleExpression ')' '{' ( statement )* '}'
    ;

doWhileExpr
    : Do '{' ( statement )* '}' While '(' singleExpression ')'
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

  identifier :
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
 | notOperator singleExpression                                           # NotExpression
 | singleExpression ( '*' | '/' | '%' ) singleExpression                  # MultiplicativeExpression
 | singleExpression ( '+' | '-' ) singleExpression                        # AdditiveExpression
 | singleExpression ( bitLeftShift | bitRigthShift ) singleExpression     # BitShiftExpression
 | singleExpression
    ( lessthan |
      greaterthan |
      lessthanorequalto |
      greaterthanorequalto
    ) singleExpression                                                    # RelationalExpression
 | singleExpression Instanceof singleExpression                           # InstanceofExpression
 | singleExpression In singleExpression                                   # InExpression
 | singleExpression ( '==' | '!=' | '===' | '!==' ) singleExpression      # EqualityExpression
 | singleExpression bitAnd singleExpression                               # BitAndExpression
 | singleExpression bitNot singleExpression                               # BitXOrExpression
 | singleExpression bitOr singleExpression                                # BitOrExpression
 | singleExpression booleanAndOperator singleExpression                   # LogicalAndExpression
 | singleExpression booleanOrOperator singleExpression                    # LogicalOrExpression
 | singleExpression '?' singleExpression ':' singleExpression             # TernaryExpression
 | singleExpression assignmentOperator expressionSequence                 # AssignmentOperatorExpression
 | This                                                                   # ThisExpression
 | literal                                                                # LiteralExpression
 | variable                                                               # VariableExpression
 | functionCall                                                           # FunctionCallExpression
/*
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

 literal
 : ( BOOLEAN | NULL )
 | DecimalLiteral
 ;

/*
 literal
  : ( NullLiteral
    | BooleanLiteral
    | StringLiteral
    | RegularExpressionLiteral
    )
  | numericLiteral
  ;

 numericLiteral
  : DecimalLiteral
  | HexIntegerLiteral
  | OctalIntegerLiteral
  ;





/// 7.8.3 Numeric Literals
HexIntegerLiteral
 : '0' [xX] HexDigit+
 ;

OctalIntegerLiteral
 : {!this.strictMode}? '0' OctalDigit+
 ;
 */

/*
 * Lexer Rules
 */

/// 7.8.3 Numeric Literals
DecimalLiteral
 : DecimalIntegerLiteral '.' DecimalDigit* ExponentPart?
 | '.' DecimalDigit+ ExponentPart?
 | DecimalIntegerLiteral ExponentPart?
 ;

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

StringLiteral
 : '"' DoubleStringCharacter* '"'
 | '\'' SingleStringCharacter* '\''
 ;


 fragment DoubleStringCharacter
  : ~["\\\r\n]
  | '\\' EscapeSequence
  | LineContinuation
  ;
 fragment SingleStringCharacter
  : ~['\\\r\n]
  | '\\' EscapeSequence
  | LineContinuation
  ;
 fragment EscapeSequence
  : CharacterEscapeSequence
  | '0' // no digit ahead! TODO
  | HexEscapeSequence
  | UnicodeEscapeSequence
  ;
 fragment CharacterEscapeSequence
  : SingleEscapeCharacter
  | NonEscapeCharacter
  ;
 fragment HexEscapeSequence
  : 'x' HexDigit HexDigit
  ;
 fragment UnicodeEscapeSequence
  : 'u' HexDigit HexDigit HexDigit HexDigit
  ;
 fragment SingleEscapeCharacter
  : ['"\\bfnrtv]
  ;

  fragment LineContinuation
   : '\\' LineTerminatorSequence
   ;

fragment LineTerminatorSequence
 : '\r\n'
 | LineTerminator
 ;

 LineTerminator
  : [\r\n\u2028\u2029] -> channel(HIDDEN)
  ;

  fragment NonEscapeCharacter
   : ~['"\\bfnrtv0-9xu\r\n]
   ;

fragment DecimalDigit
 : [0-9]
 ;
fragment HexDigit
 : [0-9a-fA-F]
 ;
fragment OctalDigit
 : [0-7]
 ;
fragment DecimalIntegerLiteral
 : '0'
 | [1-9] DecimalDigit*
 ;
fragment ExponentPart
 : [eE] [+-]? DecimalDigit+
 ;