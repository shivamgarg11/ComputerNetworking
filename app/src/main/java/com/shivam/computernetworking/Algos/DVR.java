package com.shivam.computernetworking.Algos;

public class DVR
{
    static int graph[][];
    static int via[][];
    static int rt[][];
    static int v;
    static int e;
    static StringBuilder builder = new StringBuilder();

    public static String Start(int v, int e, int[]s, int[]d, int[]c)
    {
        DVR.v = v;
        DVR.e = e;

        graph = new int[v][v];
        via = new int[v][v];
        rt = new int[v][v];
        for(int i = 0; i < v; i++)
            for(int j = 0; j < v; j++)
            {
                if(i == j)
                    graph[i][j] = 0;
                else
                    graph[i][j] = 9999;
            }

        for(int i = 0; i < e; i++)
        {
            graph[s[i]][d[i]] = c[i];
            graph[d[i]][s[i]] = c[i];
        }

        dvr_calc_disp("The Routing Tables are: ");
        return builder.toString();

    }

    static void dvr_calc_disp(String message)
    {
        init_tables();
        update_tables();
        builder.append(message+"\n");
        print_tables();
       builder.append("\n");
    }

    static void update_table(int source)
    {
        for(int i = 0; i < v; i++)
        {
            if(graph[source][i] != 9999)
            {
                int dist = graph[source][i];
                for(int j = 0; j < v; j++)
                {
                    int inter_dist = rt[i][j];
                    if(via[i][j] == source)
                        inter_dist = 9999;
                    if(dist + inter_dist < rt[source][j])
                    {
                        rt[source][j] = dist + inter_dist;
                        via[source][j] = i;
                    }
                }
            }
        }
    }

    static void update_tables()
    {
        int k = 0;
        for(int i = 0; i < 4*v; i++)
        {
            update_table(k);
            k++;
            if(k == v)
                k = 0;
        }
    }

    static void init_tables()
    {
        for(int i = 0; i < v; i++)
        {
            for(int j = 0; j < v; j++)
            {
                if(i == j)
                {
                    rt[i][j] = 0;
                    via[i][j] = i;
                }
                else
                {
                    rt[i][j] = 9999;
                    via[i][j] = 100;
                }
            }
        }
    }

    static void print_tables()
    {
        for(int i = 0; i < v; i++)
        {
            for(int j = 0; j < v; j++)
            {
               builder.append("Dist: " + rt[i][j] + "    ");
            }
            builder.append('\n');
        }
    }

}
