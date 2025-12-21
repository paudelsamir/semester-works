import React, { useState } from 'react';

function Calculator() {
  const [number1, setNumber1] = useState(0);
  const [number2, setNumber2] = useState(0);
  const [operation, setOperation] = useState('add');
  const [result, setResult] = useState(null);
  const [operationPerformed, setOperationPerformed] = useState(false);

  const compute = () => {
    let calcResult;
    const num1 = parseFloat(number1);
    const num2 = parseFloat(number2);

    switch(operation) {
      case 'add':
        calcResult = num1 + num2;
        break;
      case 'subtract':
        calcResult = num1 - num2;
        break;
      case 'multiply':
        calcResult = num1 * num2;
        break;
      default:
        calcResult = null;
    }
    
    setResult(calcResult);
    setOperationPerformed(true);
  };

  const handleClear = () => {
    setNumber1(0);
    setNumber2(0);
    setOperation('add');
    setResult(null);
    setOperationPerformed(false);
  };

  return (
    <div className="calculator-container">
      <div className="card">
        <div className="card-header">
          <h2>🧮 Calculator</h2>
        </div>
        <div className="card-body">
          
          <div className="form-group">
            <label htmlFor="num1">Number 1:</label>
            <input 
              id="num1"
              type="number" 
              value={number1} 
              onChange={(e) => setNumber1(e.target.value)}
              className="form-control"
              placeholder="Enter first number"
            />
          </div>

          <div className="form-group">
            <label htmlFor="num2">Number 2:</label>
            <input 
              id="num2"
              type="number" 
              value={number2} 
              onChange={(e) => setNumber2(e.target.value)}
              className="form-control"
              placeholder="Enter second number"
            />
          </div>

          <div className="form-group">
            <label htmlFor="operation">Operation:</label>
            <select 
              id="operation"
              value={operation} 
              onChange={(e) => setOperation(e.target.value)}
              className="form-control"
            >
              <option value="add">➕ Add</option>
              <option value="subtract">➖ Subtract</option>
              <option value="multiply">✖️ Multiply</option>
            </select>
          </div>

          <div className="button-group">
            <button onClick={compute} className="btn btn-primary">Compute</button>
            <button onClick={handleClear} className="btn btn-secondary">Clear</button>
          </div>

          {operationPerformed && (
            <div className="result-box">
              <h3>Result: <span className="result-value">{result}</span></h3>
            </div>
          )}

        </div>
      </div>

      <style>{`
        .calculator-container {
          padding: 20px;
          max-width: 400px;
          margin: 20px auto;
        }
        
        .card { 
          box-shadow: 0 2px 8px rgba(0,0,0,0.1);
          border: none;
          border-radius: 8px;
          overflow: hidden;
        }

        .card-header {
          background-color: #007bff;
          color: white;
          padding: 15px;
        }
        
        .card-body {
          padding: 20px;
        }
        
        .form-group {
          margin-bottom: 15px;
        }

        .form-group label {
          display: block;
          margin-bottom: 5px;
          font-weight: bold;
        }
        
        .form-control {
          width: 100%;
          padding: 8px;
          border: 1px solid #ddd;
          border-radius: 4px;
          font-size: 1em;
        }
        
        .button-group {
          display: flex;
          gap: 10px;
          margin-top: 20px;
        }

        .btn {
          flex: 1;
          padding: 10px;
          border: none;
          border-radius: 4px;
          cursor: pointer;
          font-weight: bold;
          font-size: 1em;
        }

        .btn-primary {
          background-color: #007bff;
          color: white;
        }

        .btn-primary:hover {
          background-color: #0056b3;
        }

        .btn-secondary {
          background-color: #6c757d;
          color: white;
        }

        .btn-secondary:hover {
          background-color: #545b62;
        }
        
        .result-box {
          margin-top: 20px;
          padding: 15px;
          background-color: #d4edda;
          border: 1px solid #c3e6cb;
          border-radius: 4px;
          text-align: center;
        }
        
        .result-value {
          font-size: 1.5em;
          font-weight: bold;
          color: #155724;
        }
      `}</style>
    </div>
  );
}

export default Calculator;
