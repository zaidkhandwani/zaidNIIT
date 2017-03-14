using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SqlClient;

namespace TestFormApp
{
    public partial class AddForm : Form
    {
        DataSet ds = null;
        public AddForm()
        {
            InitializeComponent();
        }

        private void AddForm_Load(object sender, EventArgs e)
        {
            for (int i = 0; i < 5; i++)
            {
                Label lbl = new Label();
                lbl.Location = new Point(100, 100 + (i*20));
                lbl.Text = "Hello" + i.ToString();
                lbl.Click += lbl_click;
                lbl.Tag = i.ToString();
                this.Controls.Add(lbl);
            }
            
        }

        private void lbl_click(object sender, EventArgs e)
        {
            Label l = sender as Label;
            doSomething(l.Tag.ToString());  
        }

        private void doSomething(String i)
        {
            MessageBox.Show("This is " + i + "th Label.");

            ds.Tables[0].Rows.Add();
            //dataGridView1.Rows.Add();
            ds.Tables[0].Rows[ds.Tables[0].Rows.Count - 1].ItemArray[0] = i;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            SqlConnection con = new SqlConnection("Data Source=ppwpdsql02\\sqldv2k8r2;Initial Catalog=LNTBPM;User ID=wfdbuser;Password=wfdbpassword");
            SqlCommand command = con.CreateCommand();
            command.CommandText = "Select PSNO, Name from Employee where PSNO like '%" + textBox1.Text + "%'";
            SqlDataAdapter sda = new SqlDataAdapter(command);
            ds = new DataSet();
            sda.Fill(ds);
            dataGridView1.DataSource = ds.Tables[0];
        }

        private void dataGridView1_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (dataGridView1.SelectedCells.Count > 1)
                return;
            else
            {
                int rowin = dataGridView1.SelectedCells[0].RowIndex;
                MessageBox.Show(dataGridView1.Rows[rowin].Cells[0].Value.ToString());
            }
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {
            if (textBox1.Text.Length < 3)
                return;
            SqlConnection con = new SqlConnection("Data Source=ppwpdsql02\\sqldv2k8r2;Initial Catalog=LNTBPM;User ID=wfdbuser;Password=wfdbpassword");
            SqlCommand command = con.CreateCommand();
            command.CommandText = "Select PSNO, Name from Employee where PSNO like '%" + textBox1.Text + "%'";
            SqlDataAdapter sda = new SqlDataAdapter(command);
            ds = new DataSet();
            sda.Fill(ds);
            dataGridView1.DataSource = ds.Tables[0];
        }
    }
}
