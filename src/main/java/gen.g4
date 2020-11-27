grammar gen;

program : (function | COMMENT)+;

function : header BEGIN func_command* returnValue END;

func_command : NAME LPAR args RPAR;

header : FUNCTION NAME LPAR declaration RPAR;

declaration : ((NAME COMMA)* (NAME | tail))?;

tail : NAME COMS;

returnValue : RETURN (func_command | expression);

args : ((expression COMMA)* expression)?;

expression : NAME | INTEGER | tuple;

tuple : LPAR ((expressionTuple COMMA)* expressionTuple)? RPAR;

expressionTuple : NAME | INTEGER ;

FUNCTION : 'fun';

BEGIN : '{';

END : '}';

RETURN : 'return';

COMS : '..';

INTEGER : ([1-9])([0-9])*;

COLON : ':';

COMMA : ',';

LPAR : '(';

RPAR : ')';

AP : '//';

PLUS : '+';

MINUS : '-';

DIV : '/';

MUL : '*';

EQ : '=';

COMMENT : AP ([0-9a-zA-Z*+-/=_():<> ] | '[' | ']')*;

NAME : ([a-zA-Z_])([0-9a-zA-Z_])*;

WS : [ \t\r\n]+ -> skip;