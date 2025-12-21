import express from 'express';
import path from 'path';
import { fileURLToPath } from 'url';

const app = express();
const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

app.use(express.static(path.join(__dirname, 'public')));

app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname, 'public', 'index.html'));
});

const PORT = 3000;
app.listen(PORT, () => {
  console.log(`\n✅ React Calculator App running at http://localhost:${PORT}`);
  console.log(`📍 Student: Samir Paudel (114-079/D)`);
  console.log(`📝 Lab: 26c - React Calculator\n`);
});
