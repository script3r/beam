/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.beam.dsls.sql.interpreter.operator.string;

import java.util.List;

import org.apache.beam.dsls.sql.interpreter.operator.BeamSqlExpression;
import org.apache.beam.dsls.sql.interpreter.operator.BeamSqlPrimitive;
import org.apache.beam.dsls.sql.schema.BeamSqlRow;
import org.apache.calcite.sql.type.SqlTypeName;

/**
 * 'UPPER' operator.
 */
public class BeamSqlUpperExpression extends BeamSqlStringUnaryExpression {
  public BeamSqlUpperExpression(List<BeamSqlExpression> operands) {
    super(operands, SqlTypeName.VARCHAR);
  }

  @Override public BeamSqlPrimitive evaluate(BeamSqlRow inputRow) {
    String str = opValueEvaluated(0, inputRow);
    return BeamSqlPrimitive.of(SqlTypeName.VARCHAR, str.toUpperCase());
  }
}