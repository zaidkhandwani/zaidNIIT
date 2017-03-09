using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data;
using System.Data.SqlClient;

namespace TestFormApp
{
    public partial class Db2Xl : Form
    {
        public Db2Xl()
        {
            InitializeComponent();
        }

        string conString = "Data Source=PPWPDSQL02\\SQLDV2K8R2;Initial Catalog=LNTBPM;User ID=wfdbuser;Password=wfdbpassword";
        DataTable dt;

        private void button1_Click(object sender, EventArgs e)
        {
            SaveFileDialog saveFileDialog1 = new SaveFileDialog();
            saveFileDialog1.InitialDirectory = @"C:\";
            saveFileDialog1.Title = "Save Comma Separated Values File";
            saveFileDialog1.CheckPathExists = true;
            saveFileDialog1.FileName = DateTime.Now.ToString();
            saveFileDialog1.DefaultExt = "csv";
            saveFileDialog1.Filter = "Excel file (*.csv)|*.csv";
            saveFileDialog1.FilterIndex = 1;
            saveFileDialog1.RestoreDirectory = true;

            if (saveFileDialog1.ShowDialog() == DialogResult.OK)
            {
                //textBox1.Text = saveFileDialog1.FileName;
                DataTableExtensions.WriteToCsvFile(dt, saveFileDialog1.FileName);
            }
        }

        private void Db2Xl_Load(object sender, EventArgs e)
        {
            SqlConnection con = new SqlConnection(conString);
            string sql = "Select * from Employee";
            con.Open();
            SqlCommand command = new SqlCommand(sql, con);
            SqlDataAdapter da = new SqlDataAdapter(command);
            dt = new DataTable();
            da.Fill(dt);
        }
    }

}
