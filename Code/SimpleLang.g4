grammar SimpleLang;

program: statement+;

statement: ifStatement
         | expressionStatement;

ifStatement: 'IF' '(' expression ')' '{' statement+ '}' ('ELSE' '{' statement+ '}')?;

expressionStatement: expression NEWLINE;

expression: INT
          | ID
          | '(' expression ')'
          | expression operator expression;

operator: '+' | '-' | '*' | '/';

ID: [a-zA-Z]+;
INT: [0-9]+;
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;
