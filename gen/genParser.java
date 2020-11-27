// Generated from /home/merak1t/IdeaProjects/type-inference-task/src/main/java/gen.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class genParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FUNCTION=1, BEGIN=2, END=3, RETURN=4, COMS=5, INTEGER=6, COLON=7, COMMA=8, 
		LPAR=9, RPAR=10, AP=11, PLUS=12, MINUS=13, DIV=14, MUL=15, EQ=16, COMMENT=17, 
		NAME=18, WS=19;
	public static final int
		RULE_program = 0, RULE_function = 1, RULE_func_command = 2, RULE_header = 3, 
		RULE_declaration = 4, RULE_tail = 5, RULE_returnValue = 6, RULE_args = 7, 
		RULE_expression = 8, RULE_tuple = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "function", "func_command", "header", "declaration", "tail", 
			"returnValue", "args", "expression", "tuple"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'fun'", "'{'", "'}'", "'return'", "'..'", null, "':'", "','", 
			"'('", "')'", "'//'", "'+'", "'-'", "'/'", "'*'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "FUNCTION", "BEGIN", "END", "RETURN", "COMS", "INTEGER", "COLON", 
			"COMMA", "LPAR", "RPAR", "AP", "PLUS", "MINUS", "DIV", "MUL", "EQ", "COMMENT", 
			"NAME", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "gen.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public genParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public List<TerminalNode> COMMENT() { return getTokens(genParser.COMMENT); }
		public TerminalNode COMMENT(int i) {
			return getToken(genParser.COMMENT, i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof genListener ) ((genListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof genListener ) ((genListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof genVisitor ) return ((genVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(22);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case FUNCTION:
					{
					setState(20);
					function();
					}
					break;
				case COMMENT:
					{
					setState(21);
					match(COMMENT);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(24); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==FUNCTION || _la==COMMENT );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(genParser.BEGIN, 0); }
		public ReturnValueContext returnValue() {
			return getRuleContext(ReturnValueContext.class,0);
		}
		public TerminalNode END() { return getToken(genParser.END, 0); }
		public List<Func_commandContext> func_command() {
			return getRuleContexts(Func_commandContext.class);
		}
		public Func_commandContext func_command(int i) {
			return getRuleContext(Func_commandContext.class,i);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof genListener ) ((genListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof genListener ) ((genListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof genVisitor ) return ((genVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			header();
			setState(27);
			match(BEGIN);
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NAME) {
				{
				{
				setState(28);
				func_command();
				}
				}
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(34);
			returnValue();
			setState(35);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Func_commandContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(genParser.NAME, 0); }
		public TerminalNode LPAR() { return getToken(genParser.LPAR, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(genParser.RPAR, 0); }
		public Func_commandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof genListener ) ((genListener)listener).enterFunc_command(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof genListener ) ((genListener)listener).exitFunc_command(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof genVisitor ) return ((genVisitor<? extends T>)visitor).visitFunc_command(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_commandContext func_command() throws RecognitionException {
		Func_commandContext _localctx = new Func_commandContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_func_command);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			match(NAME);
			setState(38);
			match(LPAR);
			setState(39);
			args();
			setState(40);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HeaderContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(genParser.FUNCTION, 0); }
		public TerminalNode NAME() { return getToken(genParser.NAME, 0); }
		public TerminalNode LPAR() { return getToken(genParser.LPAR, 0); }
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(genParser.RPAR, 0); }
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof genListener ) ((genListener)listener).enterHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof genListener ) ((genListener)listener).exitHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof genVisitor ) return ((genVisitor<? extends T>)visitor).visitHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_header);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(FUNCTION);
			setState(43);
			match(NAME);
			setState(44);
			match(LPAR);
			setState(45);
			declaration();
			setState(46);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(genParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(genParser.NAME, i);
		}
		public TailContext tail() {
			return getRuleContext(TailContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(genParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(genParser.COMMA, i);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof genListener ) ((genListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof genListener ) ((genListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof genVisitor ) return ((genVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declaration);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(52);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(48);
						match(NAME);
						setState(49);
						match(COMMA);
						}
						} 
					}
					setState(54);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				}
				setState(57);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(55);
					match(NAME);
					}
					break;
				case 2:
					{
					setState(56);
					tail();
					}
					break;
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TailContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(genParser.NAME, 0); }
		public TerminalNode COMS() { return getToken(genParser.COMS, 0); }
		public TailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof genListener ) ((genListener)listener).enterTail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof genListener ) ((genListener)listener).exitTail(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof genVisitor ) return ((genVisitor<? extends T>)visitor).visitTail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TailContext tail() throws RecognitionException {
		TailContext _localctx = new TailContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_tail);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(NAME);
			setState(62);
			match(COMS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnValueContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(genParser.RETURN, 0); }
		public Func_commandContext func_command() {
			return getRuleContext(Func_commandContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof genListener ) ((genListener)listener).enterReturnValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof genListener ) ((genListener)listener).exitReturnValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof genVisitor ) return ((genVisitor<? extends T>)visitor).visitReturnValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnValueContext returnValue() throws RecognitionException {
		ReturnValueContext _localctx = new ReturnValueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_returnValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(RETURN);
			setState(67);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(65);
				func_command();
				}
				break;
			case 2:
				{
				setState(66);
				expression();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(genParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(genParser.COMMA, i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof genListener ) ((genListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof genListener ) ((genListener)listener).exitArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof genVisitor ) return ((genVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_args);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << LPAR) | (1L << NAME))) != 0)) {
				{
				setState(74);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(69);
						expression();
						setState(70);
						match(COMMA);
						}
						} 
					}
					setState(76);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				}
				setState(77);
				expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(genParser.NAME, 0); }
		public TerminalNode INTEGER() { return getToken(genParser.INTEGER, 0); }
		public TupleContext tuple() {
			return getRuleContext(TupleContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof genListener ) ((genListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof genListener ) ((genListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof genVisitor ) return ((genVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expression);
		try {
			setState(83);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				match(NAME);
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				match(INTEGER);
				}
				break;
			case LPAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(82);
				tuple();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TupleContext extends ParserRuleContext {
		public TerminalNode LPAR() { return getToken(genParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(genParser.RPAR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(genParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(genParser.COMMA, i);
		}
		public TupleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tuple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof genListener ) ((genListener)listener).enterTuple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof genListener ) ((genListener)listener).exitTuple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof genVisitor ) return ((genVisitor<? extends T>)visitor).visitTuple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TupleContext tuple() throws RecognitionException {
		TupleContext _localctx = new TupleContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_tuple);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(LPAR);
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << LPAR) | (1L << NAME))) != 0)) {
				{
				setState(91);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(86);
						expression();
						setState(87);
						match(COMMA);
						}
						} 
					}
					setState(93);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				}
				setState(94);
				expression();
				}
			}

			setState(97);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\25f\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3"+
		"\2\3\2\6\2\31\n\2\r\2\16\2\32\3\3\3\3\3\3\7\3 \n\3\f\3\16\3#\13\3\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\7\6\65\n"+
		"\6\f\6\16\68\13\6\3\6\3\6\5\6<\n\6\5\6>\n\6\3\7\3\7\3\7\3\b\3\b\3\b\5"+
		"\bF\n\b\3\t\3\t\3\t\7\tK\n\t\f\t\16\tN\13\t\3\t\5\tQ\n\t\3\n\3\n\3\n\5"+
		"\nV\n\n\3\13\3\13\3\13\3\13\7\13\\\n\13\f\13\16\13_\13\13\3\13\5\13b\n"+
		"\13\3\13\3\13\3\13\2\2\f\2\4\6\b\n\f\16\20\22\24\2\2\2h\2\30\3\2\2\2\4"+
		"\34\3\2\2\2\6\'\3\2\2\2\b,\3\2\2\2\n=\3\2\2\2\f?\3\2\2\2\16B\3\2\2\2\20"+
		"P\3\2\2\2\22U\3\2\2\2\24W\3\2\2\2\26\31\5\4\3\2\27\31\7\23\2\2\30\26\3"+
		"\2\2\2\30\27\3\2\2\2\31\32\3\2\2\2\32\30\3\2\2\2\32\33\3\2\2\2\33\3\3"+
		"\2\2\2\34\35\5\b\5\2\35!\7\4\2\2\36 \5\6\4\2\37\36\3\2\2\2 #\3\2\2\2!"+
		"\37\3\2\2\2!\"\3\2\2\2\"$\3\2\2\2#!\3\2\2\2$%\5\16\b\2%&\7\5\2\2&\5\3"+
		"\2\2\2\'(\7\24\2\2()\7\13\2\2)*\5\20\t\2*+\7\f\2\2+\7\3\2\2\2,-\7\3\2"+
		"\2-.\7\24\2\2./\7\13\2\2/\60\5\n\6\2\60\61\7\f\2\2\61\t\3\2\2\2\62\63"+
		"\7\24\2\2\63\65\7\n\2\2\64\62\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67"+
		"\3\2\2\2\67;\3\2\2\28\66\3\2\2\29<\7\24\2\2:<\5\f\7\2;9\3\2\2\2;:\3\2"+
		"\2\2<>\3\2\2\2=\66\3\2\2\2=>\3\2\2\2>\13\3\2\2\2?@\7\24\2\2@A\7\7\2\2"+
		"A\r\3\2\2\2BE\7\6\2\2CF\5\6\4\2DF\5\22\n\2EC\3\2\2\2ED\3\2\2\2F\17\3\2"+
		"\2\2GH\5\22\n\2HI\7\n\2\2IK\3\2\2\2JG\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3"+
		"\2\2\2MO\3\2\2\2NL\3\2\2\2OQ\5\22\n\2PL\3\2\2\2PQ\3\2\2\2Q\21\3\2\2\2"+
		"RV\7\24\2\2SV\7\b\2\2TV\5\24\13\2UR\3\2\2\2US\3\2\2\2UT\3\2\2\2V\23\3"+
		"\2\2\2Wa\7\13\2\2XY\5\22\n\2YZ\7\n\2\2Z\\\3\2\2\2[X\3\2\2\2\\_\3\2\2\2"+
		"][\3\2\2\2]^\3\2\2\2^`\3\2\2\2_]\3\2\2\2`b\5\22\n\2a]\3\2\2\2ab\3\2\2"+
		"\2bc\3\2\2\2cd\7\f\2\2d\25\3\2\2\2\16\30\32!\66;=ELPU]a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}