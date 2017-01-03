/*
 * Copyright (C) 2007-2010 Júlio Vilmar Gesser.
 * Copyright (C) 2011, 2013-2015 The JavaParser Team.
 *
 * This file is part of JavaParser.
 * 
 * JavaParser can be used either under the terms of
 * a) the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * b) the terms of the Apache License 
 *
 * You should have received a copy of both licenses in LICENCE.LGPL and
 * LICENCE.APACHE. Please refer to those files for details.
 *
 * JavaParser is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 */
 
package com.github.javaparser.ast.expr;

import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;

import java.util.List;

import static com.github.javaparser.ast.internal.Utils.*;

/**
 * @author Julio Vilmar Gesser
 */
public final class NormalAnnotationExpr extends AnnotationExpr {

	private List<MemberValuePair> pairs;

	public NormalAnnotationExpr() {
	}

	public NormalAnnotationExpr(final NameExpr name, final List<MemberValuePair> pairs) {
		setName(name);
		setPairs(pairs);
	}

	public NormalAnnotationExpr(final int beginLine, final int beginColumn, final int endLine, final int endColumn,
			final NameExpr name, final List<MemberValuePair> pairs) {
		super(beginLine, beginColumn, endLine, endColumn);
		setName(name);
		setPairs(pairs);
	}

	@Override public <R, A> R accept(final GenericVisitor<R, A> v, final A arg) {
		return v.visit(this, arg);
	}

	@Override public <A> void accept(final VoidVisitor<A> v, final A arg) {
		v.visit(this, arg);
	}

	public List<MemberValuePair> getPairs() {
        pairs = ensureNotNull(pairs);
        return pairs;
	}

	public void setPairs(final List<MemberValuePair> pairs) {
		this.pairs = pairs;
		setAsParentNodeOf(this.pairs);
	}
}
