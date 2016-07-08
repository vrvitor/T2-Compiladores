// Generated from Luazinha.g4 by ANTLR 4.5.3
package trabalho2;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link LuazinhaVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class LuazinhaBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements LuazinhaVisitor<T> {
	PilhaDeTabelas pilhaDeTabelas = new PilhaDeTabelas();
        /**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitPrograma(LuazinhaParser.ProgramaContext ctx) { 
            { pilhaDeTabelas.empilhar(new TabelaDeSimbolos("global")); }
            T t = visitChildren(ctx); 
            { pilhaDeTabelas.desempilhar(); }
            return t;
        }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitTrecho(LuazinhaParser.TrechoContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitBloco(LuazinhaParser.BlocoContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitComando(LuazinhaParser.ComandoContext ctx) { 
            if (ctx.for1 != null) {
                { pilhaDeTabelas.empilhar(new TabelaDeSimbolos("for")); }
                pilhaDeTabelas.topo().adicionarSimbolo(ctx.n.getText(), "variavel");
                T t = visitChildren(ctx);
                { pilhaDeTabelas.desempilhar(); }
                return t;
            } else if (ctx.for2 != null) {
                { pilhaDeTabelas.empilhar(new TabelaDeSimbolos("for")); }
                T t = visitListaexp(ctx.listaexp());
                pilhaDeTabelas.topo().adicionarSimbolos(ctx.ln1.nomes, "variavel");
                t = visitListadenomes(ctx.ln1);
                t = visitBloco(ctx.bl);
                { pilhaDeTabelas.desempilhar(); }
                return t;
            } else if (ctx.ndf != null) {
                { pilhaDeTabelas.empilhar(new TabelaDeSimbolos(ctx.ndf.nome)); }
                T t = visitChildren(ctx);
                { pilhaDeTabelas.desempilhar(); }
                return t;
            } else if (ctx.listavar() != null) {
                T t = visitListaexp(ctx.listaexp());
                for (String nome : ctx.listavar().nomes) {
                    if (!pilhaDeTabelas.existeSimbolo(nome)) {
                        pilhaDeTabelas.topo().adicionarSimbolo(nome, "variavel");
                    }
                }
                t = visitListavar(ctx.listavar());
                return t;
            } else if (ctx.ln2 != null) {
                for (String nome : ctx.ln2.nomes) {
                    if (!pilhaDeTabelas.topo().existeSimboloTipo(nome, "variavel")) {
                        pilhaDeTabelas.topo().adicionarSimbolo(nome, "variavel");
                    } else {
                        System.out.println("Erro semantico: variavel local " + nome + " ja declarada");
                    }
                }
            }
            return visitChildren(ctx); 
        }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitUltimocomando(LuazinhaParser.UltimocomandoContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitNomedafuncao(LuazinhaParser.NomedafuncaoContext ctx) { 
            if (ctx.metodo) {
                pilhaDeTabelas.topo().adicionarSimbolo("self", "parametro");
            }
            return visitChildren(ctx); 
        }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitListavar(LuazinhaParser.ListavarContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitVar(LuazinhaParser.VarContext ctx) { 
            if (!pilhaDeTabelas.existeSimbolo(ctx.nome)) {
                Saida.println(ctx.linha + "," + (ctx.coluna + 1) + ":Variavel " + ctx.nome + " nao amarrada");
            }
            return visitChildren(ctx); 
        }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitListadenomes(LuazinhaParser.ListadenomesContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitListaexp(LuazinhaParser.ListaexpContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitExp(LuazinhaParser.ExpContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitExpprefixo(LuazinhaParser.ExpprefixoContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitExpprefixo2(LuazinhaParser.Expprefixo2Context ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitChamadadefuncao(LuazinhaParser.ChamadadefuncaoContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitArgs(LuazinhaParser.ArgsContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitFuncao(LuazinhaParser.FuncaoContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitCorpodafuncao(LuazinhaParser.CorpodafuncaoContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitListapar(LuazinhaParser.ListaparContext ctx) { 
            if (ctx.listadenomes() != null) {
                pilhaDeTabelas.topo().adicionarSimbolos(ctx.listadenomes().nomes, "parametro");
            }
            return visitChildren(ctx); 
        }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitConstrutortabela(LuazinhaParser.ConstrutortabelaContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitListadecampos(LuazinhaParser.ListadecamposContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitCampo(LuazinhaParser.CampoContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitSeparadordecampos(LuazinhaParser.SeparadordecamposContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitOpbin(LuazinhaParser.OpbinContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitOpunaria(LuazinhaParser.OpunariaContext ctx) { return visitChildren(ctx); }
}