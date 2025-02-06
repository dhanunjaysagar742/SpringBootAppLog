
import React, { useState, useEffect, useRef } from 'react';
import { Form, Button, Container, Row, Col } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'ag-grid-community/styles/ag-grid.css';
import 'ag-grid-community/styles/ag-theme-alpine.css';
import { AgCharts } from 'ag-charts-react';

const Chart = () => {

  const [rowData, setRowData] = useState([]); // Static row data
  const [chartData, setChartData] = useState([]); // State to store chart data
  const [chartSeriesType, setChartSeriesType] = useState("bar"); // Default chart type



  // Static data for testing
  const staticRowData = [
    { jobNo: '1', indenterName: 'Job 1', project: 'Project A', mutualAgreedPdc: 10 },
    { jobNo: '2', indenterName: 'Job 2', project: 'Project B', mutualAgreedPdc: 60 },
    { jobNo: '3', indenterName: 'Job 3', project: 'Project C', mutualAgreedPdc: 30 },
    { jobNo: '4', indenterName: 'Job 4', project: 'Project D', mutualAgreedPdc: 70 },
  ];

  

  useEffect(() => {
    // Set static data
    setRowData(staticRowData);
    setChartData(staticRowData.map(row => ({
      project: row.project,
      mutualAgreedPdc: row.mutualAgreedPdc,
    })));
  }, []);

 





  return (
    <Container>
      <Form.Control
            as="select"
            value={chartSeriesType}
            onChange={(e) => setChartSeriesType(e.target.value)}
          >
            <option value="bar">Bar</option>
            <option value="line">Line</option>
            <option value="pie">Pie</option>
            < option value="area">Area</option>
            <option value="scatter">Scatter</option>
          </Form.Control>

  
      <div style={{ marginTop: '30px', height: '300px' }}>
        {chartData.length > 0 ? (
          <AgCharts
            options={{
              data: chartData,
              series: [
                {
                  xKey: 'project',
                  yKey: 'mutualAgreedPdc',
                  type: chartSeriesType,
                  fill: '#0086F4',
                },
              ],
              title: {
                text: 'Job Data Chart',
              },
              axes: [
                {
                  type: 'category',
                  position: 'bottom',
                  title: { text: 'Project' },
                },
                {
                  type: 'number',
                  position: 'left',
                  title: { text: 'Mutual Agreed PDC' },
                },
              ],
            }}
          />
        ) : (
          <p>No data available for chart.</p>
        )}
      </div>
    </Container>
  );
};

export default Chart;